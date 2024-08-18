package com.tejait.batch12.controller;


import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.tejait.batch12.util.FileGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.data.domain.Page;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tejait.batch12.builderPattern.ApiResponse;
import com.tejait.batch12.execeptions.DataNotFoundException;
import com.tejait.batch12.execeptions.DetailsAlreadyExistsExpection;
import com.tejait.batch12.execeptions.InsufficientBalanceException;
import com.tejait.batch12.execeptions.UserDataNotFoundException;
import com.tejait.batch12.factoryDesign.FactoryDesign;
import com.tejait.batch12.model.Employee;
import com.tejait.batch12.model.Student;
import com.tejait.batch12.service.EmployeeService;


@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeService empService; //sevice bean will inject into controller bean
	
	@PostMapping("saveEmp")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee emp){
		Employee employee = empService.saveEmployee(emp);
	    return new ResponseEntity<>(employee, HttpStatus.CREATED);
		
	}
	
	@PutMapping("updateEmp")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee emp){
			      Employee employee = empService.saveEmployee(emp);
		   return new ResponseEntity<>(employee, HttpStatus.OK);               
		                 
	}
		
	@DeleteMapping("deleteEmp/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable int id){
		      empService.deleteEmployee(id);
		      return new ResponseEntity<> ("Employee Deleted " + id, HttpStatus.OK);
	}
	
	@GetMapping("getById/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable int id){
		Employee employee = empService.getEmployeeById(id);
		return new ResponseEntity<>(employee, HttpStatus.OK);
		
	}
    @GetMapping("getAll")
	public ResponseEntity<List<Employee>> getAllEmployees(){
		List<Employee> list = empService.getAllEmployees();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	    
    @GetMapping("pagination")
	public Page<Employee> pagination(@RequestParam int pageNum, @RequestParam int pageSize){
    	return empService.getPaginationEmployee(pageNum, pageSize);
	}
    
    @GetMapping("findByDept")
    public ResponseEntity<List<Employee>> findByDept(@RequestParam String dept){
    	List<Employee> list =empService.findByDept(dept);
    	return new ResponseEntity<>(list, HttpStatus.OK);
    }
    
    @GetMapping("findByFnameAndLname")
    public ResponseEntity<List<Employee>> findByFnameAndLname(@RequestParam String fname, String lname){
    	List<Employee> list = empService.findByFnameAndLname(fname, lname);
    	return new ResponseEntity<>(list, HttpStatus.OK);
    }
    
    @GetMapping("findByFnameOrLname")
    public ResponseEntity<List<Employee>> findByFnameOrLname(@RequestParam String fname, String lname){
    	List<Employee> list = empService.findByFnameOrLname(fname, lname);
    	return new ResponseEntity<>(list, HttpStatus.OK);
    	
    }
    
    @GetMapping("findByFname")
    public ResponseEntity<List<Employee>> findByFname(@RequestParam String fname){
    	List<Employee> list = empService.findByFname(fname);
    	return new ResponseEntity<>(list, HttpStatus.OK);
    }
    
    @GetMapping("findByFnameIs")
    public ResponseEntity<List<Employee>> findByFnameIs(@RequestParam String fname){
    	List<Employee> list = empService.findByFnameIs(fname);
    	return new ResponseEntity<>(list, HttpStatus.OK);
    }
    
    @GetMapping("findByFnameEquals")
    public ResponseEntity<List<Employee>> findByFnameEquals(@RequestParam String fname){
    	List<Employee> list = empService.findByFnameEquals(fname);
    	return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("findByAgeBetween/{age1}/{age2}")
    public ResponseEntity<List<Employee>> findByAgeBetween(@PathVariable int age1, @PathVariable int age2){
    	List<Employee> list = empService.findByAgeBetween(age1,age2);
    	return new ResponseEntity<>(list, HttpStatus.OK);
    }
    
    @GetMapping("findByAgeLessThan/{age}")
    public ResponseEntity<List<Employee>> findByAgeLessThan(@PathVariable int age){
    	List<Employee> list = empService.findByAgeLessThan(age);
    	return new ResponseEntity<>(list, HttpStatus.OK);
    }
    
    @GetMapping("findByAgeLessThanEqual/{age}")
    public ResponseEntity<List<Employee>> findByAgeLessThanEqual(@PathVariable int age){
    	List<Employee> ageLessThanEqual = empService.findByAGeLessThanEqual(age);
    	return new ResponseEntity<>(ageLessThanEqual, HttpStatus.OK);
    }
    
    @GetMapping("findByAgeGreaterThan/{age}")
    public ResponseEntity<List<Employee>> findByAgeGreaterThan(@PathVariable int age){
    	List<Employee> getByAgeGreterThan = empService.findByAgeGreaterThan(age);
    	return new ResponseEntity<>(getByAgeGreterThan, HttpStatus.OK);
    }
    
    @GetMapping("findByAgeGreaterThanEqual/{age}")
    public ResponseEntity<List<Employee>> findByAgeGreaterThanEqual(@PathVariable int age){
    	List<Employee> getByAgeGreterEqual = empService.findByAgeGreaterThanEqual(age);
    	return new ResponseEntity<>(getByAgeGreterEqual, HttpStatus.OK);
    }
    
    @GetMapping("findBySalaryAfter/{salary}")
    public ResponseEntity<List<Employee>> findBySalaryAfter(@PathVariable long salary){
    	List<Employee> getBySalaryAfter = empService.findBySalaryAfter(salary);
    	return new ResponseEntity<>(getBySalaryAfter, HttpStatus.OK);
    }
    
    @GetMapping("findBySalaryBefore/{salary}")
    public ResponseEntity<List<Employee>> findBySalaryBefore(@PathVariable long salary){
    	List<Employee> getBySalaryBefore =empService.findBySalaryBefore(salary);
    	return new ResponseEntity<>(getBySalaryBefore, HttpStatus.OK);
    }
    
    @GetMapping("findByAgeIsNull")
    public ResponseEntity<List<Employee>> findByAgeIsNull(){
    	List<Employee> getByAgeIsNull = empService.findByAgeIsNull();
    	return new ResponseEntity<>(getByAgeIsNull, HttpStatus.OK);
    }
    
    @GetMapping("findByAgeNotNull")
    public ResponseEntity<List<Employee>> findByAgeNotNull(){
    	List<Employee> getByageNotNull = empService.findByAgeNotNull();
    	return new ResponseEntity<>(getByageNotNull, HttpStatus.OK);
    }
    
    @GetMapping("findByFnameLike")
    public ResponseEntity<List<Employee>> findByFnameLike(@RequestParam String fname){
    	List<Employee> getByFnameLike = empService.fnameLike("%"+fname+"%");
    	return new ResponseEntity<>(getByFnameLike, HttpStatus.OK);
    }
    
    @GetMapping("findByFnameNotLike")
    public ResponseEntity<List<Employee>> findByFnameNotLike(@RequestParam String fname){
    	List<Employee> getByFnameNotLike = empService.fnameNotLike("%"+fname+"%");
    	return new ResponseEntity<>(getByFnameNotLike, HttpStatus.OK);
    }
    
    @GetMapping("findByFirstnameEndingWith")
    public ResponseEntity<List<Employee>> findByFnameEndingWith(@RequestParam String fname){
    	List<Employee> getByFnameEndWith = empService.findByFnameEndingWith(fname);
    	return new ResponseEntity<>(getByFnameEndWith, HttpStatus.OK);
    }
    
    @GetMapping("findByFnameContains")
    public ResponseEntity<List<Employee>> findByFnameContains(@RequestParam String fname){
    	List<Employee> getByContains = empService.fnameContains(fname);
    	return new ResponseEntity<>(getByContains, HttpStatus.OK);
    }
    
    @GetMapping("findByFnameStartingWith")
    public ResponseEntity<List<Employee>> findByFnameStartingWith(@RequestParam String fname){
    	List<Employee> getByStartWith = empService.findByFnameStartingWith(fname);
    	return new ResponseEntity<>(getByStartWith, HttpStatus.OK);
    }
    
    @GetMapping("findByAgeOrderByFnameDesc/{age}")
    public ResponseEntity<List<Employee>> findByAgeOrderByFnameDesc(@PathVariable Integer age){
    	List<Employee> getByAgeOrderByLname = empService.findByAgeOrderByFnameDesc(age);
    	return new ResponseEntity<>(getByAgeOrderByLname, HttpStatus.OK);
    }
    
    @GetMapping("findByAgeOrderByLnameDesc/{age}")
    public ResponseEntity<List<Employee>> findByAgeOrderByLnameDesc(@PathVariable int age){
    	List<Employee> getOrderByLname = empService.findByAgeOrderByLnameDesc(age);
    	return new ResponseEntity<>(getOrderByLname, HttpStatus.OK);
    }
    
    @GetMapping("findByLnameNot")
    public ResponseEntity<List<Employee>> findByLnameNot(@RequestParam String lname){
    	List<Employee> getLnameNot = empService.findByLnameNot(lname);
    	return new ResponseEntity<>(getLnameNot, HttpStatus.OK);
    }
    
    @GetMapping("findByDeptIn")
    public ResponseEntity<List<Employee>> findByDeptIn(@RequestParam List<String> depts){
    	List<Employee> getDeptIn = empService.findByDeptIn(depts);
    	return new ResponseEntity<>(getDeptIn, HttpStatus.OK);
    }
    
    
    @GetMapping("findByDeptNotIn")
    public ResponseEntity<List<Employee>> findByDeptNotIn(@RequestParam List<String> depts){
    	List<Employee> getDeptNotIn = empService.findByDeptNotIn(depts);
    	return new ResponseEntity<>(getDeptNotIn, HttpStatus.OK);
    }
    
    
    @GetMapping("findByFnameIgnoreCase")
    public ResponseEntity<List<Employee>> findByFnameIgnoreCase(@RequestParam String fname){
    	List<Employee> getFnameIgnoreCase = empService.findByFnameIgnoreCase(fname);
    	return new ResponseEntity<>(getFnameIgnoreCase, HttpStatus.OK);
    }
    
    @GetMapping("distinctDept")
    public ResponseEntity<List<String>> distinctDept(){
    	List<String> getDistinctDept= empService.distinctDept();
    	return new ResponseEntity<>(getDistinctDept, HttpStatus.OK);
    }
    
    @GetMapping("search")
    public ResponseEntity<List<Employee>> searchEmployeesData(@RequestParam String searchTerm){
    	List<Employee> list = empService.searchEmployess(searchTerm);
    	return new ResponseEntity<>(list, HttpStatus.OK);
    }
    
    @GetMapping("searchFilters")
    public ResponseEntity<List<Employee>> searchFilters(@RequestParam String filterType, @RequestParam String empCode){
    	List<Employee> list = empService.searchFilters(filterType, empCode);
		return new ResponseEntity<>(list, HttpStatus.OK);
    	
    }
    
//    @GetMapping("searchFiltersFname")
//    public ResponseEntity<List<Employee>> searchFiltersFname(@RequestParam String filterType, @RequestParam String fname){
//    	List<Employee> list = empService.searchFiltersFname(filterType, fname);
//    	return new ResponseEntity<List<Employee>>(list, HttpStatus.OK);
//    }
    @GetMapping("dataSorting") 
    public ResponseEntity<List<Employee>> dataSorting(@RequestParam String property, @RequestParam String orderType){
    	List<Employee> list = empService.dataSorting(property, orderType);
    	return new ResponseEntity<List<Employee>>(list, HttpStatus.OK);
    }
    
  //--------------- Custom Expection Handling---------
    @GetMapping("/userData/{userId}")
    public ResponseEntity<Boolean> userDetails(@PathVariable int userId){
         boolean result = empService.existsUserid(userId);
         if(!result) {
        	 throw new UserDataNotFoundException();
//        	 throw new InsufficientBalanceException();
//        	 throw new DetailsAlreadyExistsExpection();
//        	 throw new DataNotFoundException();
//        	 throw new UserDataNotFoundException();
         }
         return new ResponseEntity<Boolean>(result, HttpStatus.OK);
	}
    
    //--------------- Factory Design Pattern File Generation---------
   
    
    @GetMapping("/factoryDesignPattern/{type}")
    public ResponseEntity<byte[]> factoryDesignPattern(@PathVariable String type) throws IOException{
    	FactoryDesign fd = new FactoryDesign(type);
    	byte[]  fileData = fd.downloadFile(empService.getAllEmployees());
    	
    	Map<String, String> map = Map.of("pdf",  "application/pdf", 
        		"xlsx", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet", 
        		"txt",  "text/plain", 
        		"docx", "application/vnd.openxmlformats-officedocument.wordprocessingml.document");
    	
    	   String mediaType = map.get(type);
    	   
    	   String filname = "Employee. " +type;
    	   
    	HttpHeaders headers = new HttpHeaders();
    	            headers.setContentType(MediaType.parseMediaType(mediaType));
           headers.setContentDisposition(ContentDisposition.builder("attachment").filename(filname).build());
           
           
    	return new ResponseEntity<byte[]>(fileData,headers, HttpStatus.OK);
    }
    
    @GetMapping("builderDesign")
    public ResponseEntity<ApiResponse> buiderDesignPattern (@RequestHeader HttpHeaders headers){
    	return empService.builderDesignPattern(headers);
    }
}
