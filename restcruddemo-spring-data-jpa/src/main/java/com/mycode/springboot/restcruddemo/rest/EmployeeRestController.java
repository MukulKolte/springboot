package com.mycode.springboot.restcruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycode.springboot.restcruddemo.entity.Employee;
import com.mycode.springboot.restcruddemo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	private EmployeeService employeeService;

	@Autowired
	public EmployeeRestController(EmployeeService theEmployeeService) {
		super();
		employeeService = theEmployeeService;
	}
	
	//expose employees to "/employees" 
	@GetMapping("/employees")
	public List<Employee> getAllEmployees(){
		
		return employeeService.findAll();
	}
	
	
	//get employee by id number
	@GetMapping("/employees/{theId}")
	public Employee getEmployeeById(@PathVariable int theId) {
		
		Employee theEmployee = employeeService.findById(theId);
		
		if(theEmployee == null) {
			throw new RuntimeException("The employee with this id is not present.");
		}
		
		return theEmployee;
	}
	
	//add mapping for Post /employees - add new employee
	
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee theEmployee) {
		
		//just add in case user passes an id in JSON, set id to 0;
		//this is to force save of new item... instead of update
		theEmployee.setId(0);
		
		Employee dbEmployee = employeeService.save(theEmployee);
		
		return dbEmployee;
	}
	
	//add mapping for PUT/employees - update existing employee
	
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee theEmployee) {
		
		Employee dbEmployee = employeeService.save(theEmployee);
		
		return dbEmployee;
	}
	
	//add mapping to DELETE /employees/{employeeId} - delete employee
	
	@DeleteMapping("/employees/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId) {
		
		Employee tempEmployee = employeeService.findById(employeeId);
		
		if(tempEmployee == null) {
			throw new RuntimeException("Employee id is incorrrect");
		}
		
		employeeService.deleteById(employeeId);
		
		return "Deleted the employee: " + employeeId;
	}
	
}
