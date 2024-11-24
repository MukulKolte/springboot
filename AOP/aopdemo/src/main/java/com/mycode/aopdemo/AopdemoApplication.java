package com.mycode.aopdemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.mycode.aopdemo.dao.AccountDAO;
import com.mycode.aopdemo.dao.MembershipDAO;
import com.mycode.aopdemo.service.TrafficFortuneService;
import com.mycode.aopdemo.Account;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO, 
											   MembershipDAO theMembershipDAO,
											   TrafficFortuneService theTrafficFortuneService) {
		
		return runner -> {
			
//			demoTheBeforeAdvice(theAccountDAO, theMembershipDAO);
			
//			demoTheAroundAdvice(theTrafficFortuneService);
			
//			demoTheAroundAviceHandleException(theTrafficFortuneService);
			
			demoTheAroundAdviceRethrowException(theTrafficFortuneService);
		};
		
	}

	private void demoTheAroundAdviceRethrowException(TrafficFortuneService theTrafficFortuneService) throws InterruptedException {
		
		System.out.println("\nMain Program: demoTheAroundAdviceRethrowException");
		
		System.out.println("Calling getFortune()");
		
		boolean tripwire = true;
		try {
			String data = theTrafficFortuneService.getFortune(tripwire);
			System.out.println("\nMy fortune is: " + data);
		}catch (Exception exc) {
			System.out.println("Exception handled in main program: " + exc);
		}
		
		System.out.println("Finished");
	}

	private void demoTheAroundAviceHandleException(TrafficFortuneService theTrafficFortuneService) throws InterruptedException {
		
		System.out.println("\nMain Program: demoTheAroundAviceHandleException");
		
		System.out.println("Calling getFortune()");
		
		boolean tripwire = true;
		String data = theTrafficFortuneService.getFortune(tripwire);
		
		System.out.println("\nMy fortune is: " + data);
		
		System.out.println("Finished");
	}

	private void demoTheAroundAdvice(TrafficFortuneService theTrafficFortuneService) throws InterruptedException {
		
		System.out.println("\nMain Program: demoTheAroundAdvice");
		
		System.out.println("Calling getFortune()");
		
		String data = theTrafficFortuneService.getFortune();
		
		System.out.println("\nMy fortune is: " + data);
		
		System.out.println("Finished");
		
	}

	private void demoTheBeforeAdvice(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {
		
		//call the business method 
		theAccountDAO.addAccount(new Account(), true);
		
		//call the membership business method
		theMembershipDAO.addAccount();
		
//		System.out.println("Let's call it again!!");
//		
//		// call the method again
//		theAccountDAO.addAccount();
		
	}

}