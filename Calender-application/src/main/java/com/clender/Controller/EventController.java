package com.clender.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.calender.model.Event;
import com.celender.exception.EventException;
import com.celender.exception.UserException;
import com.celender.service.EventService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/calender")
public class EventController {
	
	@Autowired
	private EventService eService;
	
	@PostMapping("/event/{email}")
	public ResponseEntity<Event> createEvent(@Valid @RequestBody Event event,@PathVariable("email") String email) throws EventException, UserException{
		Event e=eService.createEvent(event, email);
		return new ResponseEntity<Event>(e, HttpStatus.CREATED);
	}
	@PutMapping("/event/{eventId}/{email}")
	public ResponseEntity<Event> updateEvent(@Valid @RequestBody Event event,@PathVariable("eventId") Integer eventId,@PathVariable("email") String email) throws EventException, UserException{
		Event e=eService.updateEvent(event, eventId, email);
		return new ResponseEntity<Event>(e, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/event/{eventId}/{email}")
	public ResponseEntity<Event> deleteEvent(@PathVariable("eventId") Integer eventId,@PathVariable("email") String email) throws EventException, UserException{
		Event e=eService.deleteEvent(eventId, email);
		return new ResponseEntity<Event>(e, HttpStatus.CREATED);
	}

}
