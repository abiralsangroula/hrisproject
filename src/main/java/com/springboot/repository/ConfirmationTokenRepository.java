package com.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springboot.model.ConfirmationToken;
import com.springboot.model.User;

public interface ConfirmationTokenRepository extends JpaRepository<ConfirmationToken, String> {
	
    ConfirmationToken findByConfirmationToken(String confirmationToksen);
    
    List<ConfirmationToken>findByUserId(Long id);
}