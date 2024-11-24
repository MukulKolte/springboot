package com.mycode.aopdemo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.mycode.aopdemo.dao.AccountDAO;
import com.mycode.aopdemo.dao.MembershipDAO;

import com.mycode.aopdemo.Account;

@SpringBootApplication
public class AopdemoApplicationPointcut {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplicationPointcut.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {
		
		return runner -> {
			
//			demoTheBeforeAdvice(theAccountDAO, theMembershipDAO);
			
//			demoTheAfterReturningAdvice(theAccountDAO);
			
//			demoTheAfterThrowingAdvice(theAccountDAO);
			
			demoTheAfterAdvice(theAccountDAO);
		};
		
	}

	private void demoTheAfterAdvice(AccountDAO theAccountDAO) {
		
		//call the method to find the accounts
		List<Account> theAccounts = null;
		try {
			//add a boolean flag to simulate exceptions
			boolean tripWire = true;
			theAccounts =  theAccountDAO.findAccounts(tripWire);
		}
		catch (Exception exc){
			System.out.println("\n\nMain Program: caught exception: " + exc);
		}
		
		///display the accounts
		System.out.println("\n\nMain Program: demoTheAfterThrowingAdvice");
		System.out.println("----");
		
		System.out.println(theAccounts);
		
		System.out.println("\n");
	}

	private void demoTheAfterThrowingAdvice(AccountDAO theAccountDAO) {
		
		//call the method to find the accounts
				List<Account> theAccounts = null;
				try {
					//add a boolean flag to simulate exceptions
					boolean tripWire = true;
					theAccounts =  theAccountDAO.findAccounts(tripWire);
				}
				catch (Exception exc){
					System.out.println("\n\nMain Program: caught exception: " + exc);
				}
				
				///display the accounts
				System.out.println("\n\nMain Program: demoTheAfterThrowingAdvice");
				System.out.println("----");
				
				System.out.println(theAccounts);
				
				System.out.println("\n");
		
	}

	private void demoTheAfterReturningAdvice(AccountDAO theAccountDAO) {
		
		//call the method to find the accounts
		List<Account> theAccounts = theAccountDAO.findAccounts();
		
		///display the accounts
		System.out.println("\n\nMain Program: demoTheAfterReturningAdvice");
		System.out.println("----");
		
		System.out.println(theAccounts);
		
		System.out.println("\n");
	}

	private void demoTheBeforeAdvice(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {
		
		//call the business method 
		theAccountDAO.addAccount(new Account("Mukul", "second"), true);
		
		//call the accountDAO getter and setter methods
		theAccountDAO.setName("Mukul");
		theAccountDAO.setServiceCode("random");
		
		theAccountDAO.getName();
		theAccountDAO.getServiceCode();
		
		//call the membership business method
		theMembershipDAO.addAccount();
		
//		System.out.println("Let's call it again!!");
//		
//		// call the method again
//		theAccountDAO.addAccount();
		
	}

}