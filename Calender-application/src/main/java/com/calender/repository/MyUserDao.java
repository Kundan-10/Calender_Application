package com.calender.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.calender.model.MyUser;

public interface MyUserDao extends JpaRepository<MyUser, Integer>{
  
	public MyUser findByUserName(String username);
}
