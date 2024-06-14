package com.in.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Ticket {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int ticketId;
	private int eventId;
	private int organizerId;
	private String ticketType;
	private int price;
	private int countOfTickets;
	private long createdAt;
	private long updatedAt;
}
