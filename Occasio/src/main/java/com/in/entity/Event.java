package com.in.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Event {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int eventId; 
	private int organizerId;
	private String organizerEmail;
	@Column(unique=true)
	private String eventName;
	private String description;
	private String location;
	private String startTime;
	private String endTime;
	private String date;
	private int capacity;
	private long createdAt;
	private long updatedAt;
}
