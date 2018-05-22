package com.SpringMySQLDB.Demo;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	@Autowired
	private userService userservice;
	
	@RequestMapping(method = RequestMethod.GET, value = "/users")
	public Collection<users> getAllUsers(){
		return userservice.getAllUsers();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/users/{userId}")
	public users getUserById(@PathVariable int userId) {
		return userservice.getUserById(userId);
	}
	
	
	@RequestMapping(method = RequestMethod.DELETE, value ="/users/{userId}")
	public void deleteUser(@PathVariable int userId) {
		userservice.deleteUser(userId);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/users")
	public void updateUser(@RequestBody users user) {
		userservice.updateUser(user);
		
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/users")
	public void insertUser(@RequestBody users user) {
		userservice.insertUser(user);
	}
	
	
	

}
