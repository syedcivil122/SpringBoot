package com.tejait.batch12.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.tejait.batch12.model.Employee;

public interface EmployeeService {

	Employee saveEmployee(Employee emp);

	void deleteEmployee(int id);

	Employee getEmployeeById(int id);

	List<Employee> getAllEmployees();

	Page<Employee> getPaginationEmployee(int pageNum, int pageSize);

	List<Employee> findByDept(String dept);

	

}
