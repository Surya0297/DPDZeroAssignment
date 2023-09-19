package com.DPDZero.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DPDZero.config.SecurityConstants;
import com.DPDZero.model.User;
import com.DPDZero.repository.UserRepository;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api")
public class GenerateTokenController {
		
	@Autowired
	private UserRepository userRepo;
	
	@GetMapping("/token")
	public ResponseEntity<Object> getLoggedInUserDetailsHandler(Authentication auth,HttpServletResponse res){
		
		
		 User user= userRepo.findByUsername(auth.getName()).orElseThrow(() -> new BadCredentialsException("Invalid Username or password"));
		
		 //to get the token in body, pass HttpServletResponse inside this method parameter 
		 Collection<String> token=res.getHeaders(SecurityConstants.JWT_HEADER);
		 
		 Map<String, Object> responseData = new HashMap<>();
	     responseData.put("status", "success");
	     responseData.put("message", "Token Generated");
	     responseData.put("token", token);
	     
	     responseData.put("data", user);
	     
		 
	     return ResponseEntity.ok().body(responseData);
		
		
	}
	
}
