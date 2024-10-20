package com.mycode.mvc;

import com.mycode.mvc.validation.CourseCode;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class Customer {

	private String firstName;
	
	@NotNull(message = "Last name cannot be null")
	@Size(min=1, message = "Last name is mandatory")
	private String lastName = "";
	
	@NotNull(message = "free Pass cannot be null")
	@Min(value = 1, message = "Free passes can't be 0 or less than zero.")
	@Max(value = 10, message = "Max 10 passes are allowed per customer")
	private Integer freePasses;
	
	@Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "Only 5 characters or digits are allowed.")
	private String postalCode;
	
	@CourseCode(value = "MUKUL", message = "Code must start with MUKUL")
	private String courseCode;
	
	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	
	public Integer getFreePasses() {
		return freePasses;
	}

	public void setFreePasses(Integer freePasses) {
		this.freePasses = freePasses;
	}

	public Customer() {
		
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
}
