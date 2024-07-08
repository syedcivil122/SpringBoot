package com.tejait.batch12.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tejait.batch12.model.Employee;
import com.tejait.batch12.model.Student;
import com.tejait.batch12.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeService empService; //sevice bean will inject into controller bean
	
	@RequestMapping(value = "saveEmp", method = RequestMethod.POST)
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee emp){
		Employee employee = empService.saveEmployee(emp);
		ResponseEntity<Employee> rs = new ResponseEntity<Employee>(employee, HttpStatus.CREATED);
		return rs;
	}
	
		@RequestMapping(value = "updateEmp", method = RequestMethod.PUT)
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee emp){
			      Employee employee = empService.saveEmployee(emp);
		   return new ResponseEntity<Employee>(employee, HttpStatus.OK);               
		                 
	}
		
	@RequestMapping(value = "deleteEmp/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteEmployee(@PathVariable int id){
		      empService.deleteEmployee(id);
		      return new ResponseEntity<String> ("Employee Deleted " + id, HttpStatus.OK);
	}
	
	@RequestMapping(value = "getById/{id}", method = RequestMethod.GET)
	public ResponseEntity<Employee> getEmployee(@PathVariable int id){
		Employee employee = empService.getEmployeeById(id);
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
		
	}
    @GetMapping("getAll")
	public ResponseEntity<List<Employee>> getAllEmployees(){
		List<Employee> list = empService.getAllEmployees();
		return new ResponseEntity<List<Employee>>(list, HttpStatus.OK);
	}
	    
    @GetMapping("pagination")
	public Page<Employee> pagination(@RequestParam int pageNum, @RequestParam int pageSize){
		Page<Employee> page = empService.getPaginationEmployee(pageNum, pageSize);
		return page;
	}
    
    @GetMapping("findByDept")
    public ResponseEntity<List<Employee>> finfByDept(@RequestParam String dept){
    	List<Employee> list =empService.findByDept(dept);
    	return new ResponseEntity<List<Employee>>(list, HttpStatus.OK);
    }
	}

