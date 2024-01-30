package com.example.demo.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="parent_crud")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParentEntity {
	
	@Id
	private int id;
	private String parentName;
	@Column(name="mobile")
	private String mobile;
	
	@OneToMany(mappedBy="parentEntity" )
	private List<StudentEntity> studentEntitys;

}
