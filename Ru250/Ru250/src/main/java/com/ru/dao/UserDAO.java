package com.ru.dao;

import java.util.List;
import com.ru.entity.User;

public interface UserDAO {
	/*add a new user*/
	public void addUser(User u);
	/*remove an existed user*/
	public void removeUser(User u);
	/*list all user*/
	public List<User> listUser();
	/*classify user's role*/
	public boolean userType(User u);
	/*get user by username*/
	public User getUserByName(String name);
	/*get user by email*/
	public User getUserByEmail(String email);
}
