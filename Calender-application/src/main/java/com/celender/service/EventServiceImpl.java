package com.celender.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.calender.model.Event;
import com.calender.model.User;
import com.calender.repository.EventDao;
import com.calender.repository.MyUserDao;
import com.calender.repository.UserDao;
import com.celender.exception.EventException;
import com.celender.exception.UserException;

@Service
public class EventServiceImpl  implements EventService{
	

	@Autowired
	private EventDao eDao;
	
	@Autowired
	private UserDao uDao;

	@Override
	public Event createEvent(Event event, String email) throws EventException, UserException {
		
		
		Optional<User> u=uDao.findById(email);
		if(u.isPresent()) {
			Event e=eDao.save(event);
			u.get().getEvents();
			uDao.save(u.get());
			return e;
		}else {
			throw new UserException("user not found");
		}
	}

	@Override
	public Event updateEvent(Event event, Integer eventId, String email) throws EventException, UserException {
		Optional<User> u=uDao.findById(email);
		if(u.isPresent()) {
		Optional<Event> e=eDao.findById(eventId);
		
		if(e.isPresent()) {
			event.setEventId(eventId);
			Event ev=eDao.save(event);
			return ev;
		}else {
			throw new EventException("Event is not present");
		}
		}else {
			throw new UserException("User not found");
		}
	}

	@Override
	public Event deleteEvent(Integer eventId, String email) throws EventException, UserException {
		Optional<User> u=uDao.findById(email);
		if(u.isPresent()) {
		Optional<Event> e=eDao.findById(eventId);
		
		if(e.isPresent()) {
			Event ev=e.get();
			List<Event> elist=u.get().getEvents();
				if(elist.contains(ev)) {
					elist.remove(ev);
					uDao.save(u.get());
					eDao.delete(e.get());
					return ev;
				}else {
					throw new EventException("Event not found");
				}
			
		}else {
			throw new EventException("Event not found");
		}
		}else {
			throw new UserException("User not found");
		}
	}
	

}
