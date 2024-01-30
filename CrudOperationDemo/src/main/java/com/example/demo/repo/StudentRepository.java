package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.ParentChildDTO;
import com.example.demo.model.StudentEntity;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {

	@Query("select se from StudentEntity se where se.name in (:name)")
	public List<StudentEntity> findByName(@Param("name") List<String> name);

	@Query("select se from StudentEntity se where se.name=:name and se.email=:email")
	public List<StudentEntity> findByNameAndEmail(@Param("name") String name, @Param("email") String email);

	@Query("select se from StudentEntity se where se.name=:name and se.email=:email")
	public List<StudentEntity> findByJoin(@Param("name") String name, @Param("email") String email);
	
	 @Query("select new com.example.demo.dto.ParentChildDTO(p.parentName,s.name,p.mobile) from ParentEntity p cross join StudentEntity s")
	public List<ParentChildDTO> findByParentChildName();
	
}
