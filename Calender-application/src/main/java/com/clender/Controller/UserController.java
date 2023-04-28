package com.clender.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.calender.model.Event;
import com.calender.model.User;
import com.celender.dto.LoginDto;
import com.celender.dto.UserDto;
import com.celender.exception.EventException;
import com.celender.exception.UserException;
import com.celender.service.UserService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

@RestController
public class UserController {
	
	@Autowired
	private UserService uService;
	
	@PostMapping("/register")
	public ResponseEntity<User> registerUser(@Valid @RequestBody User user)throws UserException{
		
		User u=uService.registerUser(user);
		
		return new ResponseEntity<User>(u, HttpStatus.CREATED);
	}
	@PutMapping("/user")
	public ResponseEntity<User> updateUser(@Valid @RequestBody UserDto user)throws UserException{
		
		User u=uService.updateUser(user);
		
		return new ResponseEntity<User>(u, HttpStatus.OK);
	}
 
	@PostMapping("/login")
	public ResponseEntity<String> loginUser(@RequestBody LoginDto login){
		
		String s=uService.loginUser(login);
		
		return new ResponseEntity<String>(s, HttpStatus.CREATED);
	}
	
	@GetMapping("/event/{email}/{type}")
	public ResponseEntity<List<Event>> getEvent(@PathVariable("type") String type,@PathVariable("email") String email) throws EventException, UserException{
		
		List<Event> elist=uService.getEvent(type, email);
		
		return new ResponseEntity<List<Event>>(elist, HttpStatus.OK);
	}

}
