package com.mycode.aopdemo.dao;

import java.util.List;

import com.mycode.aopdemo.Account;

public interface AccountDAO {
	
	//add new method : findAccounts()
	List<Account> findAccounts();
	
	List<Account> findAccounts(boolean tripWire);
	
	void addAccount(Account theAccount, boolean vipFlag);
	
	public String getName();

	public void setName(String name);

	public String getServiceCode();

	public void setServiceCode(String serviceCode);


}
