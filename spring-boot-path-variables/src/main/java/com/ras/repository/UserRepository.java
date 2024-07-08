package com.ras.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ras.entity.UserDetails;

public interface UserRepository extends JpaRepository<UserDetails, String> {

	List<UserDetails> findByCityAndGender(String city, String gender);

}
