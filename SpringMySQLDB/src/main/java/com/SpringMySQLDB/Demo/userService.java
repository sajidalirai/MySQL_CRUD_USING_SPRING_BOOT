package com.SpringMySQLDB.Demo;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class userService {
	
	@Autowired
	@Qualifier("mysql")
	private UserDataAccess userDataAccess;
	
	public Collection<users> getAllUsers(){
		return this.userDataAccess.getAllUsers();
	}
	
	public users getUserById(int id) {
		return this.userDataAccess.getUserById(id);
	}
	
	public void updateUser(users usr) {
		this.userDataAccess.updateUser(usr);
	}
	
	public void insertUser(users usr) {
		this.userDataAccess.insertUser(usr);
	}

	public void deleteUser(int userId) {
		this.userDataAccess.deleteUser(userId);
		
	}

}
