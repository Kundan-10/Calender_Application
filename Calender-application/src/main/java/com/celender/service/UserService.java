package com.celender.service;

import java.util.List;

import com.calender.model.Event;
import com.calender.model.User;
import com.celender.dto.LoginDto;
import com.celender.dto.UserDto;
import com.celender.exception.EventException;
import com.celender.exception.UserException;

public interface UserService {
	
	public User registerUser(User user)throws UserException;
	public User updateUser(UserDto user) throws UserException;
	public String  loginUser(LoginDto login);
	public List<Event> getEvent(String type,String email)throws EventException,UserException;
}


