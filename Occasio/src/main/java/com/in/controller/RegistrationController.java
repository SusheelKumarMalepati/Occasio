package com.in.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.in.service.RegistrationService;

@RestController
public class RegistrationController {
	@Autowired
	RegistrationService registrationService;
	@PostMapping(path="/registerForEvent")
	public String registerForEvent(@RequestParam int userId,@RequestParam int eventId,@RequestParam int ticketId) {
		return registrationService.registerForEvent(userId,eventId,ticketId);
	}
	
}
