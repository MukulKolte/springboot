package com.mycode.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.mycode.aopdemo.Account;

@Aspect
@Component
@Order(1)
public class MyDemoLoggingAspect {
	
	@After("execution(* com.mycode.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint) {
		
		//print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n========>>>>> Executing @After (finally) on Method: " + method);
	}
	
	@AfterThrowing(
			pointcut = "execution(* com.mycode.aopdemo.dao.AccountDAO.findAccounts(..))",
			throwing = "theExc")
	public void afterThrowingFindAccountsAdvice(
			JoinPoint theJoinPoint, Throwable theExc) {
		
		//print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n========>>>>> Executing @AfterThrowing on Method: " + method);
		
		//log the exception
		System.out.println("\n========>>>>> The exception is: " + theExc);
	}
	
	
	//add a new advice for @AfterReturning on the findAccounts method 
	@AfterReturning(
			pointcut = "execution(* com.mycode.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning = "result")
	public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result) {
		//print out which method we are advising on 
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n========>>>>> Executing @AfterReturning on Method: " + method);
		
		//print out the results of the method call
		System.out.println("\n========>>>>> Result is: " + result);
		
		//let's post process the data... Let's modify it!!
		
		//Convert account names to upper case
		converAccountNamesToUpperCase(result);
		System.out.println("\n========>>>>> Result is: " + result);
		
	}
	
	private void converAccountNamesToUpperCase(List<Account> result) {
		
		//loop through accounts
		for(Account tempAccount : result) {
		
			//get uppercase version of name
			String theUpperName = tempAccount.getName().toUpperCase();
			
			//update the name on the account
			tempAccount.setName(theUpperName);
			
		}
		
	}

	@Before("com.mycode.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		System.out.println("\n==============>>> Executing @Before advice on some method()");
		
		//display the method signature
		MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();		
		System.out.println("Method: " + methodSignature);
		
		//display method arguments
		
		//get args
		Object[] args = theJoinPoint.getArgs();
		
		//loop through args
		for(Object tempArg: args) {
			System.out.println(tempArg);
			
			if(tempArg instanceof Account) {
				
				//downcast and print Account specific stuff
				Account theAccount = (Account) tempArg;
				
				System.out.println("Account name: " + theAccount.getName());
				System.out.println("Account name: " + theAccount.getLevel());
			}
		}
	}
	
}
