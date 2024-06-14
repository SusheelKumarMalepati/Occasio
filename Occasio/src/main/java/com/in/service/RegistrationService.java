package com.in.service;

import org.springframework.stereotype.Component;

@Component
public interface RegistrationService {
	public String registerForEvent(int userId, int eventId, int ticketId);
}
