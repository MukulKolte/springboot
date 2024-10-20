package com.mycode.springcoredemo.common;

//import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
//@Lazy
public class BaseBallCoach implements Coach {
	
	public BaseBallCoach() {
		System.out.println("In Constructor: " + getClass().getSimpleName());
	}

	@Override
	public String getDailyWorkout() {

		return "Spend 30 mins in batting practice.";
	}

}
