package com.mycode.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.mycode.aopdemo.Account;

@Repository
public class AccountDAOImpl implements AccountDAO {

	@Override
	public void addAccount(Account theAccount, boolean vipFlag) {
		
		System.out.println(getClass() + ": DOING MY DB WORK OF ADDING ACCOUNT.");
		
	}
	
	@Override
	public List<Account> findAccounts() {
		
//		List<Account> myAccounts = new ArrayList<Account>();
//		
//		//create sample accounts
//		
//		Account tempAccount1 = new Account("Mukul", "first");
//		Account tempAccount2 = new Account("Chirag", "second");
//		Account tempAccount3 = new Account("Pranil", "third");
//		
//		//add them to arraylist
//		myAccounts.add(tempAccount1);
//		myAccounts.add(tempAccount2);
//		myAccounts.add(tempAccount3);
//		
//		return myAccounts;
		
		return findAccounts(false);
	}

	@Override
	public List<Account> findAccounts(boolean tripWire) {
		
		//for academic purposes ... simulate an exception
		if(tripWire) {
			throw new RuntimeException("No soup for you!!");
		}
		
		List<Account> myAccounts = new ArrayList<Account>();
		
		//create sample accounts
		
		Account tempAccount1 = new Account("Mukul", "first");
		Account tempAccount2 = new Account("Chirag", "second");
		Account tempAccount3 = new Account("Pranil", "third");
		
		//add them to arraylist
		myAccounts.add(tempAccount1);
		myAccounts.add(tempAccount2);
		myAccounts.add(tempAccount3);
		
		return myAccounts;
	}

}
