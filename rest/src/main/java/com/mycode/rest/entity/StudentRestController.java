package com.mycode.rest.entity;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import org.apache.coyote.http11.Http11InputBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycode.rest.StudentErrorResponse;
import com.mycode.rest.StudentNotFoundException;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	List<Student> theStudents;
	
	@PostConstruct
	public void loadData() {
		theStudents = new ArrayList<Student>();
		
		theStudents.add(new Student("Mukul", "Kolte"));
		theStudents.add(new Student("Vedant", "Patil"));
		theStudents.add(new Student("Pranil", "Shete"));
		
	}

	@GetMapping("/students")
	public List<Student> studentList(){
		
		return theStudents;
	}
	
	@GetMapping("/students/{studentId}")
	public Student getStudentById(@PathVariable int studentId) {
		
		//Checking Student id
		
		if((studentId >= theStudents.size()) || (studentId < 0)) {
			throw new StudentNotFoundException("Student id is not found: " + studentId);
		}
		
		return theStudents.get(studentId);
	}
	

}
