package com.calender.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.calender.model.User;

public interface UserDao extends JpaRepository<User, String>{

}
