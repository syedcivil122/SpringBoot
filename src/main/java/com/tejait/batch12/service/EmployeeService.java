package com.tejait.batch12.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import com.tejait.batch12.builderPattern.ApiResponse;
import com.tejait.batch12.model.Employee;

public interface EmployeeService {

	Employee saveEmployee(Employee emp);

	void deleteEmployee(int id);

	Employee getEmployeeById(int id);

	List<Employee> getAllEmployees();

	Page<Employee> getPaginationEmployee(int pageNum, int pageSize);

	List<Employee> findByDept(String dept);

	List<Employee> findByFnameAndLname(String fname, String lname);

	List<Employee> findByFnameOrLname(String fname, String lname);

	List<Employee> findByFname(String fname);

	List<Employee> findByFnameIs(String fname);

	List<Employee> findByFnameEquals(String fname);

	List<Employee> findByAgeBetween(int age1, int age2);

	List<Employee> findByAgeLessThan(int age);

	List<Employee> findByAGeLessThanEqual(int age);

	List<Employee> findByAgeGreaterThan(int age);

	List<Employee> findByAgeGreaterThanEqual(int age);

	List<Employee> findBySalaryBefore(long salary);

	List<Employee> findBySalaryAfter(long salary);

	List<Employee> findByAgeIsNull();

	List<Employee> findByAgeNotNull();

	List<Employee> fnameLike(String fname);

	List<Employee> fnameNotLike(String fname);

	List<Employee> fnameContains(String fname);

	List<Employee> findByFnameStartingWith(String fname);

	List<Employee> findByFnameEndingWith(String fname);

	List<Employee> findByAgeOrderByFnameDesc(Integer age);

	List<Employee> findByAgeOrderByLnameDesc(int age);

	List<Employee> findByLnameNot(String lname);

	List<Employee> findByDeptIn(List<String> depts);

	List<Employee> findByDeptNotIn(List<String> depts);

	List<Employee> findByFnameIgnoreCase(String fname);

	List<String> distinctDept();

	List<Employee> searchEmployess(String searchTerm);

	List<Employee> searchFilters(String filterType, String empCode);

	List<Employee> dataSorting(String property, String orderType);

	boolean existsUserid(int userId);

	ResponseEntity<ApiResponse> builderDesignPattern(HttpHeaders headers);

//	List<Employee> searchFiltersFname(String filterType, String fname);

	
	
//	List<Employee> findByFnameIs(String fname);

	
	

}
