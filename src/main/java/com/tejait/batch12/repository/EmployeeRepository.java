package com.tejait.batch12.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tejait.batch12.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	
	public List<Employee> findByDept(String dept);

	public List<Employee> findByFnameAndLname(String fname, String lname);

	public List<Employee> findByFnameOrLname(String fname, String lname);

	public List<Employee> findByFname(String fname);

	public List<Employee> findByFnameIs(String fname);

	public List<Employee> findByFnameEquals(String fname);

	public List<Employee> findByAgeBetween(int age1, int age2);

	public List<Employee> findByAgeLessThan(int age);

	public List<Employee> findByAgeLessThanEqual(int age);

	public List<Employee> findByAgeGreaterThan(int age);

	public List<Employee> findByAgeGreaterThanEqual(int age);

	public List<Employee> findBySalaryBefore(long salary);

	public List<Employee> findBySalaryAfter(long salary);

	public List<Employee> findByAgeIsNull();

	public List<Employee> findByAgeNotNull();

	public List<Employee> fnameLike(String fname);

	public List<Employee> fnameNotLike(String fname);

	public List<Employee> fnameContains(String fname);

	public List<Employee> findByFnameStartingWith(String fname);

	public List<Employee> findByFnameEndingWith(String fname);

	public List<Employee> findByAgeOrderByFnameDesc(Integer age);

	public List<Employee> findByAgeOrderByLnameDesc(int age);

	public List<Employee> findByLnameNot(String lname);

	public List<Employee> findByDeptIn(List<String> depts);

	public List<Employee> findByDeptNotIn(List<String> depts);

	public List<Employee> findByFnameIgnoreCase(String fname);
	
	// creating Queries Custom Queries
	@Query("select e from Employee e")
	List<Employee> getAllEmployees();
	
	@Query("select e from Employee e where e.dept=?1")
	List<Employee> getByDeparment(String dept);
	
	@Query("select e from Employee e where e.fname=?1 and e.lname=?2")
	List<Employee> getByFirstNameAndLastName(String fname, String lname);
	
	// creating param Query
	@Query("select e from Employee e where e.fname= :fname and e.lname = :lname")
	List<Employee> getByFirstNameAndLastNameParam(String fname, String lname);
	
	// creating Native Query, its works on table data
	@Query(value = "select * from employee_b12", nativeQuery = true) // Sql Query, employee is table name 
	List<Employee> getAllEmployeeNativeQuery();

	@Query("select distinct (e.dept) from Employee e")
	List<String> distinctByDept();
	
	@Query("select e from Employee e where concat(e.id,e.fname,e.lname,e.dept,e.salary,e.empCode,e.age)Like %?1%")
	List<Employee> searchEmployee(String searchTerm);
	
	//------------------------------------search Filters start -----------------------------
	
	List<Employee> findByEmpCodeStartingWith(String empCode);
	List<Employee> findByEmpCodeEndsWith(String empCode);
	List<Employee> findByEmpCodeContaining(String empCode);
	List<Employee> findByEmpCodeNotContaining(String empCode);
	List<Employee> findByEmpCode(String empCode);
	List<Employee> findByEmpCodeNot(String empCode);
	
	//------------------------------ serah Filters end---------------------------------------
	
//	List<Employee> findByFnameStatingWith(String fname);
//	List<Employee> findByFnameEndsWith(String fname);
//	List<Employee> findByFnameContaining(String fname);
//	List<Employee> findByFnameNotContaining(String fname);
////	List<Employee> findByFname(String fname);
//	List<Employee> findByFnameNot(String fname);

}
