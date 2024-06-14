package com.in.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.in.entity.EpochTime;
import com.in.entity.Event;
import com.in.entity.Role;
import com.in.entity.User;
import com.in.repository.EventRepository;
import com.in.repository.UserRepository;

@Service
public class EventServiceImpl implements EventService{
	@Autowired
	EventRepository eventRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	EpochTime epochTime;
	@Override
	public String createEvent(int organizerId,String organizerEmail,String eventName
			,String description,String location,String startTime,String endTime,String date
			,int capacity) {
		Optional<User> user=userRepository.findByEmail(organizerEmail);
		if(user.isPresent()) {
			User user1=user.get();
			if(user1.getUserID()==organizerId) {
				if(user1.getRole().equals(Role.ORGANIZER)){
					Event event=new Event();
					long epoch=epochTime.epoch();
					event.setOrganizerId(organizerId);
					event.setOrganizerEmail(organizerEmail);
					event.setEventName(eventName);
					event.setDescription(description);
					event.setLocation(location);
					event.setStartTime(startTime);
					event.setEndTime(endTime);
					event.setDate(date);
					event.setCapacity(capacity);
					event.setCreatedAt(epoch);
					event.setUpdatedAt(epoch);
					Event event1=eventRepository.save(event);
					if(event1!=null) {
						return "'message':'event created successfully','value':'"+event1+"'}";
					}
					else {
						return "{'message':'Event Creation Failure'}";
					}
				}
				else {
					return "{'message':'Event Creation Failure','reason':'does not have access to create events'}";
				}
			}
			else {
				return "{'message':'Event Creation Failure','reason':'Invalid userid associated with email'}";
			}
		}
		else {
			return "{'message':'Event Creation Failure','reason':'user not found'}";
		}
	}
	@Override
	public String searchEvent(String eventName) {
		Optional<Event> event=eventRepository.findByEventName(eventName);
		if(event.isPresent()) {
			return "'message':'event fetched successfully','value':'"+event.get()+"'}";
		}
		else {
			return "{'message':'event not found'}";
		}
	}
	@Override
	public String updateEventDetails(int organizerId, String organizerEmail, String eventName, String description,
			String location, String startTime, String endTime, String date, int capacity) {
		Optional<User> user=userRepository.findByEmail(organizerEmail);
		if(user.isPresent()) {
			User user1=user.get();
			if(user1.getUserID()==organizerId) {
				if(user1.getRole().equals(Role.ORGANIZER)) {
					Optional<Event> event=eventRepository.findByEventName(eventName);
					if(event.isPresent()) {
						Event event1=event.get();
						event1.setDescription(description);
						event1.setLocation(location);
						event1.setStartTime(startTime);
						event1.setEndTime(endTime);
						event1.setDate(date);
						event1.setCapacity(capacity);
						Event event2=eventRepository.save(event1);
						if(event2!=null) {
							return "{'message':'event details updated successfully','value':'"+event2+"'}";
						}
						else {
							return "{'message':'Event Updation Failure'}";
						}
						
					}
					else {
						return "{'message':'cannot update event','reason':'event not present'}";
					}
				}
				else {
					return "{'message':'cannot update event','reason':'you are not an organizer'}";
				}
			}
			else {
				return "{'message':'cannot update event','reason':'invalid userid associated with email'}";
			}
		}
		else {
			return "{'message':'cannot update event','reason':'user not found to create event'}";
		}
	}
}
