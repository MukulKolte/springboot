package com.mycode.springboot.restcruddemo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mycode.springboot.restcruddemo.entity.Employee;

import jakarta.persistence.EntityManager;import jakarta.persistence.TypedQuery;

@Repository
public class EmployeeDAOJPAImpl implements EmployeeDAO{

	//define field for entityManager
	
	private EntityManager entityManager;
	
	//Setup constructor injection
	@Autowired
	public EmployeeDAOJPAImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	public List<Employee> findAll() {
		
		//create a query
		
		TypedQuery<Employee> theQuery = entityManager.createQuery("FROM Employee", Employee.class);
		
		//execute the query and get the result list
		
		List<Employee> employees = theQuery.getResultList();
		
		//return the results
		return employees;
	}

	@Override
	public Employee findById(int theId) {
		
		Employee theEmployee = entityManager.find(Employee.class, theId);
		
		return theEmployee;
	}

	@Override
	public Employee save(Employee theEmployee) {
		
		Employee dbEmployee = entityManager.merge(theEmployee);
		
		return dbEmployee;
	}

	@Override
	public void deleteById(int theId) {
		
		//find the Employee
		Employee theEmployee = entityManager.find(Employee.class, theId);
		
		//remove the employee
		entityManager.remove(theEmployee);
		
	}

	
}
