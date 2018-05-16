package com.MysqlCRUDUsingSpring;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController

public class usersController {
	
	@Autowired
	usersRepository userpository;

	@GetMapping(value = "/users")
	public List<users> getAll(){
		
		return userpository.findAll();
		
	}
	
	
	
	@RequestMapping(value = "/users/{userId}")
	public Optional<users> UserById(@PathVariable int userId){
		
		return userpository.findById(userId);
		
	}

	@PostMapping(value = "/users")
	public List<users> persist(@RequestBody users person){
		userpository.save(person);
		return userpository.findAll();
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/users/{userId}")
	public void updateUser(@RequestBody users person ,@PathVariable int userId ) {
		userpository.save(person);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/users/{userId}")
	public void deleteUser(@PathVariable int userId) {
		userpository.deleteById(userId);
	}
	

}
