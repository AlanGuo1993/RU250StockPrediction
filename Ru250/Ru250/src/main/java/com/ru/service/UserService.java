package com.ru.service;


import com.ru.entity.User;

public interface UserService {

	public void addUser(String userName, String email, String pwd);
	public boolean isUsernameExist(String userName);
	public boolean isEmailExist(String email);
	
	public User login(String name, String pwd);

}