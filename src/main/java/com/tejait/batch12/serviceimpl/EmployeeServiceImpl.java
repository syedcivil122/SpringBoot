package com.tejait.batch12.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.tejait.batch12.model.Employee;
import com.tejait.batch12.repository.EmployeeRepository;
import com.tejait.batch12.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	 @Autowired
	 EmployeeRepository repository;

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
		List<Employee> list=repository.findAll();
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
		List<Employee> list= repository.findByDept(dept);
		return list;
	}
	
	
	  
	 
	 
	 
}
