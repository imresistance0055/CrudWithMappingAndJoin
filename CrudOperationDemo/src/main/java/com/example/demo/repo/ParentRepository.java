package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.ParentEntity;

public interface ParentRepository extends JpaRepository<ParentEntity, Integer>{

}
