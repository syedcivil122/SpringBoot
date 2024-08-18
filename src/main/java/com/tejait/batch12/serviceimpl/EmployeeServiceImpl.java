package com.tejait.batch12.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Sort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tejait.batch12.builderPattern.ApiResponse;
import com.tejait.batch12.builderPattern.ResponseBuilder;
import com.tejait.batch12.enums.SearchFilters;
import com.tejait.batch12.model.Employee;
import com.tejait.batch12.repository.EmployeeRepository;
import com.tejait.batch12.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	 @Autowired
	 EmployeeRepository repository;
	 
	 @Autowired
	 ResponseBuilder responseBuilder;
	 
	@Override
	public Employee saveEmployee(Employee emp) {
		// business logic
		String fname = emp.getFname();
		String lname = emp.getLname();
		String fullname = fname.concat(" " +lname);
		emp.setFullname(fullname);
		Employee savedEmp = repository.save(emp);
		return savedEmp;
	}

	@Override
	public void deleteEmployee(int id) {
		repository.deleteById(id);
		
	}

	@Override
	public Employee getEmployeeById(int id) {
	Optional<Employee>	emp = repository.findById(id);
		return emp.get();
	}

	@Override
	public List<Employee> getAllEmployees() {
//		List<Employee> list=repository.findAll();
//		List<Employee> list = repository.getAllEmployees();
		List<Employee> list = repository.getAllEmployeeNativeQuery();
		return list;
	}

	@Override
	public Page<Employee> getPaginationEmployee(int pageNum, int pageSize) {
		PageRequest pageable = PageRequest.of(pageNum, pageSize);
		Page<Employee> page = repository.findAll(pageable);
		return page;
	}

	@Override
	public List<Employee> findByDept(String dept) {
//		List<Employee> list= repository.findByDept(dept);
		List<Employee> list= repository.getByDeparment(dept);
		return list;
	}

	@Override
	public List<Employee> findByFnameAndLname(String fname, String lname) {
//		List<Employee> list = repository.findByFnameAndLname(fname, lname);
//		List<Employee> list = repository.getByFirstNameAndLastName(fname, lname);
		List<Employee> list= repository.getByFirstNameAndLastNameParam(fname, lname);
		return list;
	}

	@Override
	public List<Employee> findByFnameOrLname(String fname, String lname) {
		List<Employee> list = repository.findByFnameOrLname(fname, lname);
		return list;
	}

	@Override
	public List<Employee> findByFname(String fname) {
		List<Employee> list = repository.findByFname(fname);
		return list;
	}

	@Override
	public List<Employee> findByFnameIs(String fname) {
		List<Employee> list =repository.findByFnameIs(fname);
		return list;
	}

	@Override
	public List<Employee> findByFnameEquals(String fname) {
		List<Employee> list = repository.findByFnameEquals(fname);
		return list;
	}

	@Override
	public List<Employee> findByAgeBetween(int age1, int age2) {
		List<Employee> list = repository.findByAgeBetween(age1, age2);
		return list;
	}

	@Override
	public List<Employee> findByAgeLessThan(int age) {
		List<Employee> list = repository.findByAgeLessThan(age);
		return list;
	}

	@Override
	public List<Employee> findByAGeLessThanEqual(int age) {
		List<Employee> list = repository.findByAgeLessThanEqual(age);
		return list;
	}

	@Override
	public List<Employee> findByAgeGreaterThan(int age) {
		List<Employee> list = repository.findByAgeGreaterThan(age);
		return list;
	}

	@Override
	public List<Employee> findByAgeGreaterThanEqual(int age) {
		List<Employee> list = repository.findByAgeGreaterThanEqual(age);
		return list;
	}

	@Override
	public List<Employee> findBySalaryBefore(long salary) {
		List<Employee> list = repository.findBySalaryBefore(salary);
		return list;
	}

	@Override
	public List<Employee> findBySalaryAfter(long salary) {
		List<Employee> list = repository.findBySalaryAfter(salary);
		return list;
	}

	@Override
	public List<Employee> findByAgeIsNull() {
		List<Employee> list = repository.findByAgeIsNull();
		return list;
	}

	@Override
	public List<Employee> findByAgeNotNull() {
		List<Employee> list = repository.findByAgeNotNull();
		return list;
	}

	@Override
	public List<Employee> fnameLike(String fname) {
		List<Employee> list = repository.fnameLike(fname);
		return list;
	}

	@Override
	public List<Employee> fnameNotLike(String fname) {
		List<Employee> list = repository.fnameNotLike(fname);
		return list;
	}

	@Override
	public List<Employee> fnameContains(String fname) {
		List<Employee> list = repository.fnameContains(fname);
		return list;
	}

	@Override
	public List<Employee> findByFnameStartingWith(String fname) {
		List<Employee> list = repository.findByFnameStartingWith(fname);
		return list;
	}
	
	@Override
	public List<Employee> findByFnameEndingWith(String fname) {
		List<Employee> list = repository.findByFnameEndingWith(fname);
		return list;
	}

	@Override
	public List<Employee> findByAgeOrderByFnameDesc(Integer age) {
		List<Employee> list = repository.findByAgeOrderByFnameDesc(age);
		return list;
	}

	@Override
	public List<Employee> findByAgeOrderByLnameDesc(int age) {
		List<Employee> list = repository.findByAgeOrderByLnameDesc(age);
		return list;
	}

	@Override
	public List<Employee> findByLnameNot(String lname) {
		List<Employee> list= repository.findByLnameNot(lname);
		return list;
	}

	@Override
	public List<Employee> findByDeptIn(List<String> depts) {
		List<Employee> list = repository.findByDeptIn(depts);
		return list;
	}

	@Override
	public List<Employee> findByDeptNotIn(List<String> depts) {
		List<Employee> list = repository.findByDeptNotIn(depts);
		return list;
	}

	@Override
	public List<Employee> findByFnameIgnoreCase(String fname) {
		List<Employee> list = repository.findByFnameIgnoreCase(fname);
		return list;
	}

	@Override
	public List<String> distinctDept() {
	
		return repository.distinctByDept();
	}

	@Override
	public List<Employee> searchEmployess(String searchTerm) {
		
		return repository.searchEmployee(searchTerm);
	}

	@Override
	public List<Employee> searchFilters(String filterType, String empCode) {
		SearchFilters filters = SearchFilters.valueOf(filterType);
		
		List<Employee> list = new ArrayList<Employee>(); // empty list
		switch(filters) {
		case startWith: 
			 list = repository.findByEmpCodeStartingWith(empCode);
			 break;
		case endsWith:
		     list = repository.findByEmpCodeEndsWith(empCode);
		     break;
		case contains:
			list = repository.findByEmpCodeContaining(empCode);
			break;
		case notContains:
		    list = repository.findByEmpCodeNotContaining(empCode);
		    break;
		case equals:
			list = repository.findByEmpCode(empCode);
			break;
		case notEquals:
		    list = repository.findByEmpCodeNot(empCode);
		    break;
		    
		default:
			list = repository.getAllEmployees();
			break;
		}
		return list;
	 
}

	@Override
	public List<Employee> dataSorting(String property, String orderType) {
		
		if(orderType.equalsIgnoreCase("desc"))
				return repository.findAll(org.springframework.data.domain.Sort.by(Direction.DESC, property));
		
		return repository.findAll(org.springframework.data.domain.Sort.by(Direction.ASC, property));
		
	}

	@Override
	public boolean existsUserid(int userId) {
		return repository.existsById(userId);
	}

	@Override
	public ResponseEntity<ApiResponse> builderDesignPattern(HttpHeaders headers) {
	     List<Employee> list = repository.findAll();
		return responseBuilder.buildResponse(headers, 200, "Employees Data Fetch Successfully", list);
	}
}
