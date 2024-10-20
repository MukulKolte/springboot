package com.mycode.springboot.thymeleafdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.mycode.springboot.thymeleafdemo.model.Student;

@Controller
public class StudentController {
	
	@Value("${countries}")
	private List<String> countries;
	
	@Value("${languages}")
	private List<String> languages;
	
	@Value("${systems}")
	private List<String> systems;
	
	@GetMapping("/showStudent")
	public String showForm(Model theModel) {
		
		//create new Student
		
		Student theStudent = new Student();
		
		//add object to model
		
		theModel.addAttribute("student", theStudent);
		
		theModel.addAttribute("countries", countries);
		
		theModel.addAttribute("alllanguages", languages);
		
		theModel.addAttribute("systems", systems);
		
		return "student-form";
	}
	
	@PostMapping("/processStudentForm")
	public String processForm(@ModelAttribute("student") Student theStudent) {
		
		//log the input data
		
		System.out.println("theStudent: " + theStudent.getFirstName() + " " + theStudent.getLastName());
		
		return "student-confirmation";
	}
}
