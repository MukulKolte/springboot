package com.mycode.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {

	//Add an exception handler using @ExceptionHandler
	
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc){
		
		//Create a StudentErrorResponse
		
		StudentErrorResponse error = new StudentErrorResponse();
		
		error.setStatusCode(HttpStatus.NOT_FOUND.value());
		error.setMessage(exc.getMessage());
		error.setTimestamp(System.currentTimeMillis());
		
		//Return ResponseEntity
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	//add another exeption handler to catch any type of exception
	
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(Exception exc){
		
	//Create a StudentErrorResponse
		
		StudentErrorResponse error = new StudentErrorResponse();
		
		error.setStatusCode(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exc.getMessage());
		error.setTimestamp(System.currentTimeMillis());
		
		//Return ResponseEntity
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
}
