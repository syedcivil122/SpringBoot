package com.tejait.batch12.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.tejait.batch12.model.Employee;
import com.tejait.batch12.model.Student;
import com.tejait.batch12.repository.StudentRepository;
import com.tejait.batch12.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{
	
	List<Student> list;
	@Autowired
	StudentRepository repository;

	@Override
	public Student saveStudent(Student std) {
		// business logic
		String fname = std.getFname();
		String lname = std.getLname();
		String fullname = fname.concat(" "+lname);
		std.setFullname(fullname);
		Student savedStd = repository.save(std);
		return savedStd;
	}

	@Override
	public List<Student> getStudents() {
		
		return list;
	}

	@Override
	public void deleteStudent(int id) {
		repository.deleteById(id);
		
	}

	@Override
	public Student getEmployeeById(int id) {
	Optional<Student>	list =repository.findById(id);
		return list.get();
	}

	@Override
	public List<Student> getAllStudent() {
		List<Student> list = repository.findAll();
		return list;
	}

	@Override
	public Page<Student> getPaginationStudent(int pageNum, int pageSize) {
		PageRequest pageable = PageRequest.of(pageNum, pageSize);
		Page<Student> page = repository.findAll(pageable);
		return page;
	}
	
	

	@Override
	public List<Student> findByGender(String gender) {
		List<Student> list = repository.findByGender(gender);
		return list;
	}

	@Override
	public List<Student> findByDept(String dept) {
		List<Student> list = repository.findByDept(dept);
		return list;
	}

}
