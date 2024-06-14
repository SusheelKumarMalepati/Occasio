package com.in.service;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.in.entity.Role;
import com.in.entity.User;

@Component
public interface UserService {
	public String createUser(String firstName, String lastName, String email, String password, String phoneNumber,
			Role role);
	public String login(String email,String password);
	public Optional<User> getUser(String email);
	public String changePassword(String email, String password, String confirmPassword);
	public String updateDetails(String firstName, String lastName, String email, String password, String phoneNumber,
			Role role);
	
}