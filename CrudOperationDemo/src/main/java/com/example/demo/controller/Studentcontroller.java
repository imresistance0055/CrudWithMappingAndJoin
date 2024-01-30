package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ParentChildDTO;
import com.example.demo.dto.RequestDTO;
import com.example.demo.dto.RequestDTOs;
import com.example.demo.model.ParentEntity;
import com.example.demo.model.StudentEntity;
import com.example.demo.repo.ParentRepository;
import com.example.demo.repo.StudentRepository;
import com.example.demo.service.StudentService;

import ResponseDTO.ResponseDTO;

@RestController
@RequestMapping("/api")
public class Studentcontroller {

	@Autowired
	private StudentRepository repo;

	@Autowired
	private StudentService service;
	@Autowired
	private ParentRepository parentRepository;

	@GetMapping("/getbyid/{id}")
	public StudentEntity findById(@PathVariable Integer id) {

		return repo.findById(id).get();

	}

	@GetMapping("/getAll")
	public List<StudentEntity> findAll() {

		return repo.findAll();

	}

	@PostMapping("/save")
	public StudentEntity save(@RequestBody StudentEntity entity) {

		return repo.save(entity);
	}

	@PostMapping("/saveAll")
	public List<StudentEntity> saveAll(@RequestBody List<StudentEntity> entity) {

		return repo.saveAll(entity);
	}
	
	@PostMapping("/saveAllParent")
	public List<ParentEntity> saveAllParent(@RequestBody List<ParentEntity> entity) {

		return parentRepository.saveAll(entity);
	}
	
	@PostMapping("/saveAllParentchild")
	public String saveAllParentAndChild(@RequestBody RequestDTOs dtOs) {

		ParentEntity entity=dtOs.getEntity();
		
		List<StudentEntity> studentEntities=dtOs.getStudents();
		
		for(StudentEntity studentEntity:studentEntities) {
			studentEntity.setParentEntity(entity);
			
		}
		
		 parentRepository.save(entity);
		 repo.saveAll(studentEntities);
		 
		 return "save both";
	}

	@GetMapping("/count")
	public Long getCount() {

		return repo.count();
	}

	@DeleteMapping("/deleteById/{id}")
	public String deleteByID(@PathVariable Integer id) {

		repo.deleteById(id);

		return "delete successfully";
	}

	@DeleteMapping("/deleteAll")
	public String deleteAll() {

		repo.deleteAll();
		return "delete All";
	}

	@DeleteMapping("/deleteAllById")
	public String deleteAllById(List<Integer> id) {

		repo.deleteAllById(id);
		return "delete All";
	}

	@DeleteMapping("/deleteAllByBatch")
	public String deleteIdBatch(List<Integer> id) {

		repo.deleteAllByIdInBatch(id);
		return "delete All";
	}

	@GetMapping("/findBySort")
	public List<StudentEntity> findBySort() {

		Sort sort = Sort.by(Direction.DESC, "age");

		return repo.findAll(sort);
	}

	@GetMapping("/page")
	public List<StudentEntity> findByPageObject() {

		Pageable pageable = PageRequest.of(2, 3);

		Page<StudentEntity> findAll = repo.findAll(pageable);

		return findAll.getContent();
	}

	@GetMapping("/pageAll")
	public List<StudentEntity> findByPageObjectByArgument(@PageableDefault(size = 4) Pageable pageable) {
		Page<StudentEntity> findAll = repo.findAll(pageable);

		return findAll.getContent();
	}

	@GetMapping("/findByName/{name}")
	public List<RequestDTO> findByNameAndEail(@PathVariable String name) {

		List<RequestDTO> findByNameAndUser = service.findByNameAndUser(name);

		return findByNameAndUser;
	}
	
	@GetMapping("/findB/{name}/{email}")
	public List<StudentEntity> findByNameEail(@PathVariable String name,@PathVariable String email) {

		List<StudentEntity> findByNameAndUser = service.findByNameAndEmail(name,email);

		return findByNameAndUser;
	}
	@GetMapping("/findDataByParentId/{parentId}")
	public List<ResponseDTO> getdata(@PathVariable Integer parentId){
		
		List<ResponseDTO> data = service.getData(parentId);
		
		return data;
	}
	@GetMapping("/getdataByParentChild")
	public List<ParentChildDTO> getdataByParentChild(){
		
		return repo.findByParentChildName();
		
	
	}
}
