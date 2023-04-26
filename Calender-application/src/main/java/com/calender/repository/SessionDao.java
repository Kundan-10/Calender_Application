package com.calender.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.calender.model.CurrentUserSession;

public interface SessionDao extends JpaRepository<CurrentUserSession, Integer>{

	public CurrentUserSession findByUuid(String uuid);
}
