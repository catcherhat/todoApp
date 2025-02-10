package com.serpro.Masterdata.service;


import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

	
	public boolean authenticate(String username, String password) {
		boolean isValidUser = username.equalsIgnoreCase("Rajalakshmi");
		boolean isValidPass = password.equalsIgnoreCase("123");
		
		return isValidUser && isValidPass;
	}
}
