package com.in.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.in.entity.EpochTime;
import com.in.entity.Role;
import com.in.entity.Ticket;
import com.in.entity.User;
import com.in.repository.TicketRepository;
import com.in.repository.UserRepository;

@Service
public class TicketServiceImpl implements TicketService{
	@Autowired
	TicketRepository ticketRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	EpochTime epochTime;
	@Override
	public String createTicket(int eventId,int organizerId, String ticketType, int price, int countOfTickets) {
		Optional<User>user=userRepository.findById(organizerId);
		if(user.isPresent()) {
			User user1=user.get();
			if(user1.getRole().equals(Role.ORGANIZER)) {
				long epoch=epochTime.epoch();
				Ticket ticket=new Ticket();
				ticket.setEventId(eventId);
				ticket.setOrganizerId(organizerId);
				ticket.setTicketType(ticketType);
				ticket.setPrice(price);
				ticket.setCountOfTickets(countOfTickets);
				ticket.setCreatedAt(epoch);
				ticket.setUpdatedAt(epoch);
				Ticket ticket1=ticketRepository.save(ticket);
				if(ticket1!=null) {
					return "{'message':'ticket created successfully','value':'"+ticket1+"'}";
				}
				else {
					return "{'message':'ticket creation Failure'}";
				}
			}
			else {
				return "{'message':'ticket creation failed','value':'not an oranizer to create a ticket'}";
			}
		}
		else {
			return "{'message':'ticket creation failed','value':'organizer not found in details'}";
		}
	}
	@Override
	public String searchTicket(int eventId) {
		List<Ticket> ticket=ticketRepository.getByEventId(eventId);
		return "{'message':'the ticket types that are present','value':'"+ticket+"'}";
	}
	@Override
	public String updateTicketDetails(int ticketId,int organizerId, int eventId, String ticketType, int price, int countOfTickets) {
		Optional<User>user=userRepository.findById(organizerId);
		if(user.isPresent()) {
			User user1=user.get();
			if(user1.getRole().equals(Role.ORGANIZER)) {
				long epoch=epochTime.epoch();
				Optional<Ticket> ticket=ticketRepository.findByTicketId(ticketId);
				if(ticket.isPresent()) {
					Ticket ticket1=ticket.get();
					if(ticket1.getOrganizerId()==organizerId) {
						if(ticket1.getEventId()==eventId) {
							ticket1.setTicketType(ticketType);
							ticket1.setPrice(price);
							ticket1.setCountOfTickets(countOfTickets);
							ticket1.setUpdatedAt(epoch);
							Ticket ticket2=ticketRepository.save(ticket1);
							if(ticket2!=null) {
								return "{'message':'ticket updated successfully','value':'"+ticket2+"'}";
							}
							else {
								return "{'message':'ticket updation Failure'}";
							}
						}
						else {
							return "{'message':'cannot update ticket','type':'invalid eventId associated with ticketId'}";
						}
					}
					else {
						return "{'message':'cannot update ticket','type':'invalid organizerId associated with ticketId and eventId'}";
					}
				}
				else {
					return "{'message':'cannot update ticket','type':'ticket not found to update'}";
				}
			}
			else {
				return "{'message':'cannot update ticket','type':'you are not an organizer to update event details'}";
			}
		}
		else {
			return "{'message':'cannot update ticket','type':'User not exist'}";
		}
	}
	@Override
	public String deleteTicket(int eventId, int organizerId, String ticketType) {
		Optional<Ticket> ticket=ticketRepository.findTicketByEventIdAndTicketType(eventId,ticketType);
		Optional<User>user=userRepository.findById(organizerId);
		if(user.isPresent()) {
			User user1=user.get();
			if(user1.getRole().equals(Role.ORGANIZER)) {
				if(ticket.isPresent()) {
					Ticket ticket1=ticket.get();
					if(ticket1.getOrganizerId()==organizerId) {
						ticketRepository.delete(ticket1);
						return "{'message':'ticket deleted successfully,'value':'"+ticket1+"'}";
					}
					else {
						return "{'message':'cannot delete ticket','type':'invalid organizerId associated with eventId'}";
					}
				}
				else {
					return "{'message':'cannot delete ticket','type':'ticket not found with eventId and ticketType'}";
				}
			}
			else {
				return "{'message':'cannot delete ticket','type':'you are not an organizer to delete ticket'}";
			}
		}
		else {
			return "{'message':'cannot delete ticket','type':'User doesnot exist'}";
		}
	}
}
