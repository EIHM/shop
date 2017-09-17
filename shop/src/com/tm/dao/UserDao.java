package com.tm.dao;

import com.tm.domain.User;

public interface UserDao {

	
	public abstract User getUsers(String name,String password);
	
	public abstract void regist(String name,String password);
	
	public abstract boolean isUserHas(String name);
	
	
	
}