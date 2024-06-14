package com.in.service;

import org.springframework.stereotype.Component;

@Component
public interface EventService { 
	public String createEvent(int organizerId,String organizerEmail,String eventName
			,String description,String location,String startTime,String endTime,String date
			,int capacity);
	public String searchEvent(String eventName);
	public String updateEventDetails(int organizerId, String organizerEmail, String eventName, String description,
			String location, String startTime, String endTime, String date, int capacity);
}
