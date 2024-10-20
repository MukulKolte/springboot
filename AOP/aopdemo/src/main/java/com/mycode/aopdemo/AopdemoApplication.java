package com.mycode.aopdemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.mycode.aopdemo.dao.AccountDAO;
import com.mycode.aopdemo.dao.MembershipDAO;

import com.mycode.aopdemo.Account;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {
		
		return runner -> {
			
			demoTheBeforeAdvice(theAccountDAO, theMembershipDAO);
		};
		
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