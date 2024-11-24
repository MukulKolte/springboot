package com.luv2code.springboot.thymeleafdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class DemoLoggingAspect {
	
	//setup logger
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	//setup pointcut declarations
	@Pointcut("execute(* com.luv2code.springboot.thymeleafdemo.controller.*.*(..))")
	private void forControllerPackage() {}
	
	//do the same thing for service and dao package
	@Pointcut("execute(* com.luv2code.springboot.thymeleafdemo.dao.*.*(..))")
	private void forDaoPackage() {}
	
	@Pointcut("execute(* com.luv2code.springboot.thymeleafdemo.service.*.*(..))")
	private void forServicePackage() {}
	
	@Pointcut("forControllerPackage() || forDaoPackage() || forServicePackage()")
	private void forAppFlow() {}
	
	// add @Before advice
	
	@Before("forAppFlow()")
	public void before(JoinPoint theJoinPoint) {
		
		//display method that we are calling
		String theMethod =  theJoinPoint.getSignature().toShortString();
		myLogger.info(" =======> in @Before: Calling method: " + theMethod);
		System.out.println("Logging");
		
		//display the arguments to the method
	}
	
//	@Before("execute(* * com.luv2code.springboot.thymeleafdemo.controller.EmployeeController.listEmployees(*))")
//	public void testing(JoinPoint theJoinPoint) {
//		//display method that we are calling
//				String theMethod =  theJoinPoint.getSignature().toShortString();
//				myLogger.info(" =======> in @Before: Calling method: " + theMethod);
//	}
	
}
