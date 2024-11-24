package com.mycode.aopdemo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	//this is where we add all of our related advice for logging
	
	//let's start with an @Before advice
	
	@Before("execution(public void com.mycode.aopdemo.dao.AccountDAOImpl.addAccount(..))")
	public void beforeAddAccountAdvice() {
			
		System.out.println("\n==============>>> Executing @Before advice on addAccount()");
	}
	
	@Around("execution(* com.mycode.aopdemo.service.*.getFortune(..))")
	public Object aroundGetFortune(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {
		
		//print out the method we are advising on
		String method = theProceedingJoinPoint.getSignature().toShortString();
		System.out.println("\n========>>>>> Executing @Around on Method: " + method);
		
		//get begin timestamp
		long begin = System.currentTimeMillis();
		
		//now let's execute the method
		Object result = null;
		
		try {
		    result = theProceedingJoinPoint.proceed();
		}catch (Exception exc){
			//log the exception
			System.out.println(exc.getMessage());
			
			//give user a custom message
//			result = "Major accident!! But no worries, your private AOP helicopter is on the way to pick you up!!";
			
			throw exc;
		}
		
		//get end timestamp
		long end = System.currentTimeMillis();
		
		//compute duration and display it
		long duration = end - begin;
		System.out.println("\n=====> Duration: " + duration/ 1000.0 + " seconds");
		
		return result;
	}
}
