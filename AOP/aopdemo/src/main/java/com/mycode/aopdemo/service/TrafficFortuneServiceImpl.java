package com.mycode.aopdemo.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;

@Service
public class TrafficFortuneServiceImpl implements TrafficFortuneService {

	@Override
	public String getFortune() throws InterruptedException {
		
		//simulate the delay
		TimeUnit.SECONDS.sleep(5);
		
		//return a fortune
		return "Expect heavy traffic this morning";
	}

	@Override
	public String getFortune(boolean tripwire) throws InterruptedException {
		if(tripwire) {
			throw new RuntimeException("Major accident! Highway is closed!");
		}

		return getFortune();
	}

}
