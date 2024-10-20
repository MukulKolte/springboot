package com.mycode.springboot.restcruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mycode.springboot.restcruddemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

	//That's it!! No need to write any code.
}
