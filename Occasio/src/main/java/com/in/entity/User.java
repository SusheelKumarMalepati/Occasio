package com.in.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

@Entity
@Data
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userID;
	private String firstName;
	private String lastName;
	@Column(unique=true)
	private String email;
	private String password;
	private String phoneNumber;
	private Role role;
	private long createdAt;
	private long updatedAt;
}