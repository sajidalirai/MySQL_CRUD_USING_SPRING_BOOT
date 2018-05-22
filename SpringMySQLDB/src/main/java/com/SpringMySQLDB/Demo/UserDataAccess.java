package com.SpringMySQLDB.Demo;

import java.util.Collection;

public interface UserDataAccess {
	
	public Collection<users> getAllUsers();
	
	public users getUserById(int id);
	
	public void updateUser(users usr);
	
	public void insertUser(users usr);

	public void deleteUser(int userId);

}
