package com.ras.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ras.dto.UserInformation;
import com.ras.dto.UserRegistrationDto;
import com.ras.entity.UserDetails;
import com.ras.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;

	public String createUser(UserRegistrationDto userRegistrationDto) {
		
		UserDetails userDetails = new UserDetails();
		userDetails.setName(userRegistrationDto.getName());
		userDetails.setEmail(userRegistrationDto.getEmail());
		userDetails.setContact(userRegistrationDto.getContact());
		userDetails.setGender(userRegistrationDto.getGender());
		userDetails.setPassword(userRegistrationDto.getPassword());
		userDetails.setCity(userRegistrationDto.getCity());
		
		userRepository.save(userDetails);
		return "User Registration is Completed.";
	}
	
	public UserInformation getUserInfromationByEmail(String emailId) {
		
		// Database Interaction
		// JDBC : select * from user_details where email=emailId;
		// JPA :
		
		UserDetails userDetails = userRepository.findById(emailId).get();
		
//		Never use Entity class object as transfering data between controller and service layeer.
		
		// entity -> dto
		UserInformation info = new UserInformation();
		info.setCity(userDetails.getCity());
		info.setContact(userDetails.getContact());
		info.setGender(userDetails.getGender());
		info.setName(userDetails.getName());
		
		return info;
	}

	public List<UserDetails> getUsersInfoByCityAndGender(String city, String gender) {
		
//		JPA : Custom findBy method
		return userRepository.findByCityAndGender(city, gender);
	}

}
