package com.mycode.springboot.restcruddemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycode.springboot.restcruddemo.dao.EmployeeRepository;
import com.mycode.springboot.restcruddemo.entity.Employee;


@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;
	
	//Injection of EmployeeDAO
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}



	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}
	
	@Override
	public Employee findById(int theId) {	
		Optional<Employee> result =  employeeRepository.findById(theId); 
		
		Employee theEmployee = null;
		
		if(result.isPresent()) {
			theEmployee = result.get();
		}
		else {
			throw new RuntimeException("Couldn't find the employee with provided ID: "+ theId);
		}
		return theEmployee;
	}


	@Override
//	@Transactional -- We can remove this annotation as JPA repository provides this functionality out of the box
	public Employee save(Employee theEmployee) {
		return employeeRepository.save(theEmployee);
	}



	@Override
//	@Transactional
	public void deleteById(int Id) {
		employeeRepository.deleteById(Id);
	}



}
