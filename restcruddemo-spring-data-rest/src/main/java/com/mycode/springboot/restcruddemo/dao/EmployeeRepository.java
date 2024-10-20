package com.mycode.springboot.restcruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.mycode.springboot.restcruddemo.entity.Employee;

//@RepositoryRestResource(path = "members") -- To change the default url /employees to /members
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

	//That's it!! No need to write any code.
}
