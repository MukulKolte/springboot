package com.mycode.springcoredemo.common;

//import org.springframework.beans.factory.config.ConfigurableBeanFactory;
//import org.springframework.beans.factory.config.ConfigurableBeanFactory;
//import org.springframework.context.annotation.Scope;
//import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
//@Lazy
//@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class TrackCoach implements Coach{
	
	public TrackCoach() {
		System.out.println("In Constructor: " + getClass().getSimpleName());
	}
	
	@PostConstruct
	public void doMyStartUpStuff() {
		System.out.println("Inside doMyStartUpStuff: " + getClass().getSimpleName());
	}

	
	@PreDestroy
	public void doMyCleanUpStuff() {
		System.out.println("Inside doMyCleanUpStuff: " + getClass().getSimpleName());
	}
	
	@Override
	public String getDailyWorkout() {

		return "Run a hard 5k!";
	}

}
