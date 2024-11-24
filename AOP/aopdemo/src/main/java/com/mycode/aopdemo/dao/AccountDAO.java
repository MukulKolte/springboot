package com.mycode.aopdemo.dao;

import java.util.List;

import com.mycode.aopdemo.Account;

public interface AccountDAO {

	void addAccount(Account theAccount, boolean vipFlag);
	
	//add new method : findAccounts()
		List<Account> findAccounts();
		
		List<Account> findAccounts(boolean tripWire);
		
}
