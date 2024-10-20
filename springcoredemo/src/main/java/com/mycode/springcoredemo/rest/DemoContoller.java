package com.mycode.springcoredemo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycode.springcoredemo.common.Coach;

@RestController
public class DemoContoller {
	
	//Field injection
//	@Autowired
	private Coach myCoach;
	
//	private Coach anotherCoach;
	
	
	//Constructor method
	@Autowired
	public DemoContoller(@Qualifier("aquatic")Coach theCoach
//						@Qualifier("trackCoach") Coach anotherCoach
						) {
		System.out.println("In Constructor: " + getClass().getSimpleName());
		myCoach = theCoach;
//		this.anotherCoach = anotherCoach;
	}
	
	//Setter method
//	@Autowired
//	public void setCoach(Coach theCoach) {
//		myCoach = theCoach;
//	}
	
	@GetMapping("/dailyworkout")
	public String getDailyWorkout() {
		return myCoach.getDailyWorkout();
	}
	
//	@GetMapping("/check")
//	public String checkBeanScope() {
//		return "Check result is: " + (myCoach==anotherCoach);
//	}
}
