package com.in.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.in.service.EventService;

@RestController
public class EventController {
	@Autowired
	EventService eventService;
	@PostMapping(path="/createEvent")
	public String createEvent(@RequestParam int organizerId,@RequestParam String organizerEmail
			,@RequestParam String eventName,@RequestParam String description,@RequestParam String location
			,@RequestParam String startTime,@RequestParam String endTime,@RequestParam String date
			,@RequestParam int capacity) {
		return eventService.createEvent(organizerId, organizerEmail, eventName, description, location, startTime, endTime, date, capacity);
	}
	@GetMapping(path="/findEvent")
	public String searchEvent(@RequestParam String eventName) {
		return eventService.searchEvent(eventName);
	}
	@PutMapping(path="/updateEventDetails")
	public String updateEventDetails(@RequestParam int organizerId,@RequestParam String organizerEmail
			,@RequestParam String eventName,@RequestParam String description,@RequestParam String location
			,@RequestParam String startTime,@RequestParam String endTime,@RequestParam String date
			,@RequestParam int capacity) {
		return eventService.updateEventDetails(organizerId,organizerEmail,eventName,description,location
			,startTime,endTime,date,capacity);
	}
}
