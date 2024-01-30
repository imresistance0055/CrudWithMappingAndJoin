package com.example.demo.dto;

import java.util.List;

import com.example.demo.model.ParentEntity;
import com.example.demo.model.StudentEntity;

import lombok.Data;

@Data
public class RequestDTOs {
	
	
	List<StudentEntity> students;
	
	private ParentEntity entity;

}
