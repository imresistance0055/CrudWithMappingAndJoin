package com.example.demo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.RequestDTO;
import com.example.demo.dto.RequestDTOs;
import com.example.demo.exceptionHandle.CustomDeepakException;
import com.example.demo.model.ParentEntity;
import com.example.demo.model.StudentEntity;
import com.example.demo.repo.ParentRepository;
import com.example.demo.repo.StudentRepository;

import ResponseDTO.ResponseDTO;

@Service
public class StudentService {

	private final static Logger log = LoggerFactory.getLogger(StudentService.class);
	@Autowired
	private StudentRepository repo;
	@Autowired
	private ParentRepository parentrepo;

	public List<RequestDTO> findByNameAndUser(String name) {

		List<RequestDTO> dtos = new ArrayList<>();
		List<StudentEntity> students = repo.findByName(Arrays.asList("dee", "kum"));

		if (students != null) {
			RequestDTO dto = new RequestDTO();
			for (StudentEntity entity : students) {
				dto.setName(entity.getName());
				dto.setAge(String.valueOf(entity.getAge()));
				dto.setStateName("BIHAR");

				dtos.add(dto);

			}
		} else {

			throw new CustomDeepakException("EMPTY", "Student is not present");

		}
		return dtos;

	}

	public List<StudentEntity> findByNameAndEmail(String name, String email) {

		List<StudentEntity> byNameAndEmail = repo.findByNameAndEmail(name, email);

		return byNameAndEmail;
	}

	// fatch response data

	public List<ResponseDTO> getData(Integer parentId) {

		List<ResponseDTO> dtos = new ArrayList<>();

		log.info("data fetch starting");

		Optional<ParentEntity> parents = parentrepo.findById(parentId);

		if (parents.isPresent()) {

			List<StudentEntity> students = parents.get().getStudentEntitys();

			if (students != null) {

				for (StudentEntity student : students) {
					ResponseDTO dto = new ResponseDTO();
					dto.setParentName(student.getParentEntity().getParentName());
					dto.setStudentage(String.valueOf(student.getAge()));
					dto.setAddress(student.getAddress());
					dto.setMobileNumber(student.getMobile());
					dto.setParentMobileNumber(student.getParentEntity().getMobile());
					dto.setNoOfchild("10");

					dtos.add(dto);
				}

			} else {

				throw new CustomDeepakException("EMPTY", "Student is not present");
			}

			return dtos;

		} else {

			throw new CustomDeepakException("EMPTY", "Parent is not present");
		}
	}
}
