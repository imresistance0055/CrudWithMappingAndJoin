package com.example.demo.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name="stu_crud")
@AllArgsConstructor
@NoArgsConstructor
public class StudentEntity {
	
	@Id
	private int id;
	private String name;
	private String address;
	private int age;
	private String email;
	private String mobile;
	
	@ManyToOne
	@JoinColumn(name="parent_child_id")
	private ParentEntity parentEntity;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public ParentEntity getParentEntity() {
		return parentEntity;
	}

	public void setParentEntity(ParentEntity parentEntity) {
		this.parentEntity = parentEntity;
	}
	
	
	
	

}

