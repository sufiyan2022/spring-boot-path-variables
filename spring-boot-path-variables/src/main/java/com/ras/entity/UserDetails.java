package com.ras.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "user_Details")
public class UserDetails {
	
	@Id
	@Column(length = 20)
	private String email;
	@Column(length = 150)
	private String name;
	@Column(length = 10)
	private String contact;
	@Column(length = 6)
	private String gender;
	@Column(length = 10)
	private String city;
	@Column(length = 20)
	private String password;

	
	
}
