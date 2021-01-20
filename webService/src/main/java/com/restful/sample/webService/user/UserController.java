package com.restful.sample.webService.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class UserController {
	
	@Autowired
	private UserDaoService service;

	@GetMapping("/users")
	public List<User> retrueveAllUsers(){
		return service.findAll();
	}
	
	@GetMapping("/users/{id}")
	public User retrueveUser(@PathVariable int id){
		return service.findOne(id);
	}
	
	@PostMapping("/users")
	public User createUser(@RequestBody User user){
		return service.save(user);
	}
}
