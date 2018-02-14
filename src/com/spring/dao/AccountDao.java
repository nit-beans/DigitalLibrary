package com.spring.dao;

import java.util.List;

import com.spring.model.Account;


public interface AccountDao {
	
	public List<Account> list(int userId);

}
