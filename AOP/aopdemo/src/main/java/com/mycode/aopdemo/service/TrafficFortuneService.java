package com.mycode.aopdemo.service;

public interface TrafficFortuneService {

	String getFortune() throws InterruptedException;

	String getFortune(boolean tripwire) throws InterruptedException; 
}
