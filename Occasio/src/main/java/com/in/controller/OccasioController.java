package com.in.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.in.entity.EpochTime;
import com.in.service.UserService;

@Controller
public class OccasioController {
	@Autowired
	UserService userService;
	@Autowired
	EpochTime epochTime;
	//	@GetMapping("/")
	//	public String main() {
	//		return "Login";
	//	}
	//	@GetMapping("/Login")
	//	public String Login() {
	//		return "Login";
	//	}
	//	@GetMapping("/Register")
	//	public String Register() {
	//		return "Register";
	//	}
	//	@GetMapping("/Home")
	//	public String home() {
	//		return "Home";
	//	}
	
}