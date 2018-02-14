package com.spring.dao;


import com.spring.model.Login;

public interface LoginDao {

	public boolean authenticate(Login login);
	public boolean adminLogin(Login login);
	public int getId(Login login);
}
