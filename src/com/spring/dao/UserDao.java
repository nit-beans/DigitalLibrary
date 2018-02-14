package com.spring.dao;


import com.spring.model.User;

public interface UserDao {
	
	public void register(User user);
	public User get(int id);

}
