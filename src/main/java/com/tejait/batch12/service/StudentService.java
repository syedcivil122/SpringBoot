package com.tejait.batch12.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.tejait.batch12.model.Student;

public interface StudentService {

	Student saveStudent(Student std);
	
	public List<Student> getStudents();

	void deleteStudent(int id);

	Student getEmployeeById(int id);

	List<Student> getAllStudent();

	Page<Student> getPaginationStudent(int pageNum, int pageSize);

	List<Student> findByGender(String gender);

	List<Student> findByDept(String dept);

	
}
