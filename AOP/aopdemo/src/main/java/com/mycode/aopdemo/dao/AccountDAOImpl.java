package com.mycode.aopdemo.dao;

import org.springframework.stereotype.Repository;

import com.mycode.aopdemo.Account;

@Repository
public class AccountDAOImpl implements AccountDAO {

	@Override
	public void addAccount(Account theAccount, boolean vipFlag) {
		
		System.out.println(getClass() + ": DOING MY DB WORK OF ADDING ACCOUNT.");
	}

}
