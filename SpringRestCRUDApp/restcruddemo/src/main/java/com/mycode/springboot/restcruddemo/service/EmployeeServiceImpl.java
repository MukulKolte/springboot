package com.mycode.springboot.restcruddemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycode.springboot.restcruddemo.dao.EmployeeDAO;
import com.mycode.springboot.restcruddemo.entity.Employee;

import jakarta.transaction.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDAO employeeDAO;
	
	//Injection of EmployeeDAO
	@Autowired
	public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
		super();
		this.employeeDAO = employeeDAO;
	}



	@Override
	public List<Employee> findAll() {
		return employeeDAO.findAll();
	}
	
	@Override
	public Employee findById(int theId) {	
		return employeeDAO.findById(theId);
	}


	@Override
	@Transactional
	public Employee save(Employee theEmployee) {
		return employeeDAO.save(theEmployee);
	}



	@Override
	@Transactional
	public void deleteById(int Id) {
		employeeDAO.deleteById(Id);
	}

}
