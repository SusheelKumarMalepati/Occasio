package com.in.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.in.service.TicketService;

@RestController
public class TicketController {
	@Autowired
	TicketService ticketService;
	@PostMapping(path="/createTicket")
	public String createTicket(@RequestParam int eventId,@RequestParam int organizerId,@RequestParam String ticketType,@RequestParam int price,@RequestParam int countOfTickets) {
		return ticketService.createTicket(eventId,organizerId,ticketType,price,countOfTickets);
	}
	@GetMapping(path="/ticketTypes")
	public String searchTicket(@RequestParam int eventId) {
		return ticketService.searchTicket(eventId);
	}
	@PutMapping(path="/updateTicketDetails")
	public String updateTicketDetails(@RequestParam int ticketId,@RequestParam int organizerId,@RequestParam int eventId,@RequestParam String ticketType,@RequestParam int price,@RequestParam int countOfTickets) {
		return ticketService.updateTicketDetails(ticketId,organizerId,eventId,ticketType,price,countOfTickets);
	}
	@DeleteMapping(path="/deleteTicket")
	public String deleteTicket(@RequestParam int eventId,@RequestParam int organizerId,@RequestParam String ticketType) {
		return ticketService.deleteTicket(eventId,organizerId,ticketType);
	}
}
