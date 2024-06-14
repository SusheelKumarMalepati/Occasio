package com.in.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class RegistrationDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int registrationId;
	private int eventId;
	private int userId;
	private int ticketId;
	private long registrationDate;
	private RegistrationStatus registrationStatus;
}
