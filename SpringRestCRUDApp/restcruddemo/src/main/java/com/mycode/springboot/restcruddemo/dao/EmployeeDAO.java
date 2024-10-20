package com.mycode.springboot.restcruddemo.dao;

import java.util.List;

import com.mycode.springboot.restcruddemo.entity.Employee;

public interface EmployeeDAO {

	List<Employee> findAll();
	
	Employee findById(int theId);
	
	Employee save(Employee theEmployee);
	
	void deleteById(int theId);
}
