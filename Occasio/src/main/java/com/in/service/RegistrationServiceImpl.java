package com.in.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.in.entity.EpochTime;
import com.in.entity.Event;
import com.in.entity.RegistrationDetails;
import com.in.entity.RegistrationStatus;
import com.in.entity.Ticket;
import com.in.entity.User;
import com.in.repository.EventRepository;
import com.in.repository.RegistrationRepository;
import com.in.repository.TicketRepository;
import com.in.repository.UserRepository;

@Service
public class RegistrationServiceImpl implements RegistrationService{
	@Autowired
	RegistrationRepository registrationRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	TicketRepository ticketRepository;
	@Autowired
	EventRepository eventRepository;
	@Autowired
	EpochTime epochTime;
	@Override
	public String registerForEvent(int userId, int eventId, int ticketId) {
		long epoch=epochTime.epoch();
		Optional<User> user=userRepository.findById(userId);
		RegistrationDetails details=new RegistrationDetails();
		details.setEventId(eventId);
		details.setTicketId(ticketId);
		details.setUserId(userId);
		details.setRegistrationDate(epoch);
		if(user.isPresent()) {
			Optional<Event> event=eventRepository.findById(eventId);
			if(event.isPresent()) {
				Optional<Ticket> ticket=ticketRepository.findById(ticketId);
				if(ticket.isPresent()) {
					int registrationsDone=(int) registrationRepository.count();
					if(registrationsDone<event.get().getCapacity()) {
						details.setRegistrationStatus(RegistrationStatus.SUCCESS);
						RegistrationDetails details1=registrationRepository.save(details);
						if(details1!=null) {
							return "{'message':'User registered for successfully','value':'"+details+"'}";
						}
						else {
							details.setRegistrationStatus(RegistrationStatus.FAILURE);
							registrationRepository.save(details);
							return "{'message':'user registration Failure for the event'}";
						}
					}
					else {
						return "{'message':'Cannot register for event','type':'ticketQuata Full'}";
					}
				}
				else {
					return "{'message':'Cannot register for event','type':'request ticket does not exist'}";
				}
			}
			else {
				return "{'message':'Cannot register for event','type':'event does not exist'}";
			}
		}
		else {
			return "{'message':'Cannot register for event','type':'register as a user to register for the event'}";
		}
	}
}
