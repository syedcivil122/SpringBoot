package com.tejait.batch12.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tejait.batch12.model.Student;
import com.tejait.batch12.service.StudentService;

import lombok.Getter;


@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	StudentService stdService;
	
	@PostMapping("saveStd")
	public ResponseEntity<Student> saveStudent(@RequestBody Student std){
		return ResponseEntity.status(HttpStatus.CREATED).body(stdService.saveStudent(std));
		
	}
	
	@PutMapping("updateStd")
	public ResponseEntity<Student> updateStudent(@RequestBody Student std){
		Student student = stdService.saveStudent(std);
		return new ResponseEntity<>(student, HttpStatus.OK);
	}
	
	@DeleteMapping("deleteStd/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable int id){
		    stdService.deleteStudent(id); 
		    return new ResponseEntity<>("Employee Deleted "+ id, HttpStatus.OK);
	}
	
	@GetMapping("getById/{id}")
	public ResponseEntity<Student> getByStudent(@PathVariable int id){
		Student student = stdService.getEmployeeById(id);
		return new ResponseEntity<>(student, HttpStatus.OK);
		
	}
	
	@GetMapping("getAll")
	public ResponseEntity<List<Student>> getAllStudent(){
		List<Student> list = stdService.getAllStudent();
		return new ResponseEntity<>(list, HttpStatus.OK);
		
	}
	
	@GetMapping("pagination")
	public Page<Student> pagination(@RequestParam int pageNum, @RequestParam int pageSize){
		return stdService.getPaginationStudent(pageNum, pageSize);
	}
	
	@GetMapping("dept")
	public ResponseEntity<List<Student>> findByDept(@RequestParam String dept){
		List<Student> list = stdService.findByDept(dept);
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	@GetMapping("gender")
	public ResponseEntity<List<Student>> findByGender(@RequestParam String gender){
		List<Student> list = stdService.findByGender(gender);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
}
