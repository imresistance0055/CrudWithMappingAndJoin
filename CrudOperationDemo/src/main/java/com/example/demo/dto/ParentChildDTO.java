package com.example.demo.dto;

import lombok.Data;

@Data
public class ParentChildDTO {

	private String parentName;
	private String studentName;
	private String parentMobileNumber;

	public ParentChildDTO(String parentName, String studentName, String parentMobileNumber) {
		super();
		this.parentName = parentName.concat(" This is my father");
		this.studentName = studentName;
		this.parentMobileNumber = parentName.concat("+91").concat(parentMobileNumber);
	}

}
