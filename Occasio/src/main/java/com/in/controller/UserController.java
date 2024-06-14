package com.in.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.in.entity.Role;
import com.in.service.UserService;

@RestController
public class UserController {
	@Autowired
	UserService userService;
	@PostMapping(path="/createUser")
	public String createUser(@RequestParam String firstName,@RequestParam String lastName
			,@RequestParam String email, @RequestParam String password,@RequestParam String phoneNumber
			,@RequestParam Role role) {
		return userService.createUser(firstName,lastName,email,password,phoneNumber,role);
	}
	@GetMapping(path="/login")
	public String login(@RequestParam String email,@RequestParam String password) {
		return userService.login(email, password);
	}
	@PutMapping(path="/changePassword")
	public String changePassword(@RequestParam String email,@RequestParam String password,@RequestParam String confirmPassword) {
		return userService.changePassword(email,password,confirmPassword);
	}
	@PutMapping(path="/updateUserDetails")
	public String updateDetails(@RequestParam String firstName,@RequestParam String lastName
			,@RequestParam String email, @RequestParam String password,@RequestParam String phoneNumber
			,@RequestParam Role role) {
		return userService.updateDetails(firstName,lastName,email,password,phoneNumber,role);
	}
}
