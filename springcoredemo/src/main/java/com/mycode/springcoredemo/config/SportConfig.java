package com.mycode.springcoredemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mycode.springcoredemo.common.Coach;
import com.mycode.springcoredemo.common.SwimCoach;

@Configuration
public class SportConfig {

	@Bean("aquatic")
	public Coach swimCoach() {
		return new SwimCoach();
	}
}
