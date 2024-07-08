package com.tejait.batch12.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tejait.batch12.model.Student;


@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{
	
	public List<Student> findByGender(String gender);
	
	public List<Student> findByDept(String dept);
}
