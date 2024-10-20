package com.mycode.cruddemo.dao;

import java.util.List;

import com.mycode.cruddemo.entity.Student;

public interface StudentDAO {

	void save(Student theStudent);
	
	Student findById(Integer ID);
	
	List<Student> findAll();
	
	List<Student> findByLastname(String lastname);
	
	void updateStudent(Student theStudent);
	
	void updateWithQuery();
	
	void deleteStudent(int id);
	
	void deleteAll();
}
