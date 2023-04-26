package com.calender.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.calender.model.Event;

public interface EventDao extends JpaRepository<Event, Integer>{

}
