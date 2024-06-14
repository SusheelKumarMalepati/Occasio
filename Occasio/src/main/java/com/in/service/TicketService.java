package com.in.service;

import org.springframework.stereotype.Component;

@Component
public interface TicketService {
	public String createTicket(int eventId,int organizerId, String ticketType, int price, int countOfTickets);
	public String searchTicket(int eventId);
	public String updateTicketDetails(int ticketId,int organizerId, int eventId, String ticketType, int price, int countOfTickets);
	public String deleteTicket(int eventId, int organizerId, String ticketType);
}
