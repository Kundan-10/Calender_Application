package com.celender.service;

import com.calender.model.Event;
import com.celender.exception.EventException;
import com.celender.exception.UserException;

public interface EventService{
	
	public Event createEvent(Event event,String email)throws EventException,UserException;
	
	public Event updateEvent(Event event,Integer eventId,String email) throws EventException,UserException;
	
	public Event deleteEvent(Integer eventId,String email) throws EventException,UserException;

}
