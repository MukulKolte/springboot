package com.mycode.springboot.restcruddemo.service;

import java.util.List;

import com.mycode.springboot.restcruddemo.entity.Employee;

public interface EmployeeService {

	List<Employee> findAll();
	
	Employee findById(int theId);
	
	Employee save(Employee theEmployee);
	
	void deleteById(int Id);
}
