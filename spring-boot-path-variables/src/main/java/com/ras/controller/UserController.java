package com.ras.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ras.dto.UserInformation;
import com.ras.dto.UserRegistrationDto;
import com.ras.entity.UserDetails;
import com.ras.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;
	
//	Register User Information
	@PostMapping("/users/register")
	public String createUser(@RequestBody UserRegistrationDto userRegistrationDto) {
		
		return userService.createUser(userRegistrationDto);
	}
	
//	Getting data by passing EmailId
	@GetMapping("/users/{emailId}")
	public UserInformation getUserInfromationByEmail(@PathVariable("emailId") String emailId) {
		
//		Path variable value passing to service layer
		UserInformation info = userService.getUserInfromationByEmail(emailId);
		return info;
	}
	
//	Req: get users based on city and gender
	
	@GetMapping("/users/{city}/{gender}")
	public List<UserDetails> getUsersInfoByCityAndGender(@PathVariable String city, @PathVariable String gender){
		
		System.out.println("User information based on Gender : "+gender + " and City : "+ city);
		List<UserDetails> users = userService.getUsersInfoByCityAndGender(city,gender);
		return users;
	}
	
//	Query parameter
	
//	Req : get users with their email Id
	
	@GetMapping("/users")
	public UserInformation getUserData(@RequestParam(name = "email") String emailId) {
		return userService.getUserInfromationByEmail(emailId);
	}
	
//	Req : gender and city
	@GetMapping("/users/data")
	public List<UserDetails> getDataByCityAndGender(@RequestParam(name = "gender") String gender, @RequestParam(name = "city", required = false) String city){
		
		System.out.println("Data for Gender : "+ gender);
		System.out.println("Data for City : "+ city);
		
		return null;
	}
}
