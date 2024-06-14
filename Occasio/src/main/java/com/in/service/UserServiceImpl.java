package com.in.service;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.in.entity.EpochTime;
import com.in.entity.Role;
import com.in.entity.User;
import com.in.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserRepository userRepository;
	@Autowired
	EpochTime epochTime;
	@Override
	public String createUser(String firstName, String lastName, String email, String password, String phoneNumber,
			Role role){
		User user=new User();
		long epoch=epochTime.epoch();
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setEmail(email);
		user.setPassword(password);
		user.setPhoneNumber(phoneNumber);
		user.setRole(role);
		user.setCreatedAt(epoch);
		userRepository.save(user);
		user.setUpdatedAt(epoch);
		return "{'message':'user created successfully','value':'"+user+"'}";
	}
	@Override
	public String login(String email, String password) {
		Optional<User> user=userRepository.findUserByEmailAndPassword(email, password);
		if(user.isPresent()) {
			return "{'message':'user loggedin successfully','value':'"+user.get()+"'}";
		}
		else {
			return "{'message':'cannot login','reason':'Credentials Invalid login failed'}";
		}
	}
	@Override
	public Optional<User> getUser(String email){
		return userRepository.findByEmail(email);
	}
	@Override
	public String changePassword(String email, String password, String confirmPassword) {
		long epoch=epochTime.epoch();
		Optional<User> user=getUser(email);
		if(user.isPresent()) {
			User user1=user.get();
			if(Objects.equals(password, confirmPassword)) {
				user1.setPassword(password);
				user1.setUpdatedAt(epoch);
				userRepository.save(user1);				
				return "{'message':'changed successsfully','value':'"+user1+"'}";
			}
			else {
				return "{'message':'cannot change password','reason':'retype password correctly'}";
			}
		}
		else {
			return "{'message':'cannot change password','reason':'invalid email'}";
		}
	}
	@Override
	public String updateDetails(String firstName, String lastName, String email, String password, String phoneNumber,
			Role role) {
		long epoch=epochTime.epoch();
		Optional<User> user=getUser(email);
		if(user.isPresent()) {
			User user1=user.get();
			if(user1.getPassword().equals(password)) {
				user1.setFirstName(firstName);
				user1.setLastName(lastName);
				user1.setPhoneNumber(phoneNumber);
				user1.setRole(role);
				user1.setUpdatedAt(epoch);
				userRepository.save(user1);
				return "{'message':'details updated successfully','value':'"+user1+"'}";
			}
			else {
				return "{'message':'cannot update details','reason':'Mismatch username and password'";
			}
		}
		else {
			return "{'message':'user doesnot found'}";
		}
	}
}
