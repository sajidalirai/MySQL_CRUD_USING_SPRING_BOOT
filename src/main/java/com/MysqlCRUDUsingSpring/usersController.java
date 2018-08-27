package com.MysqlCRUDUsingSpring;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

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
	public List<users> getAll(HttpServletResponse response){
		response.setHeader("Cache-Control", "no-transform, public, max-age=600");
	    response.setHeader("Pragma", "");
		return userpository.findAll();
		
	}
	
	@RequestMapping(value = "/users/{userId}")
	public Optional<users> UserById(HttpServletResponse response,@PathVariable int userId){
		response.setHeader("Cache-Control", "no-transform, public, max-age=600");
	    response.setHeader("Pragma", "");
		return userpository.findById(userId);
	}

	@PostMapping(value = "/users")
	public List<users> persist(HttpServletResponse response, @RequestBody users person){
		response.setHeader("Cache-Control", "no-transform, public, , max-age=600");
	    response.setHeader("Pragma", "");
		userpository.save(person);
		return userpository.findAll();
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/users/{userId}")
	public void updateUser(HttpServletResponse response, @RequestBody users person ,@PathVariable int userId ) {
		response.setHeader("Cache-Control", "no-transform, public, max-age=600");
	    response.setHeader("Pragma", "");
		userpository.save(person);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/users/{userId}")
	public void deleteUser(HttpServletResponse response, @PathVariable int userId) {
		response.setHeader("Cache-Control", "no-transform, public, max-age=600");
	    response.setHeader("Pragma", "");
		userpository.deleteById(userId);
	}
}
