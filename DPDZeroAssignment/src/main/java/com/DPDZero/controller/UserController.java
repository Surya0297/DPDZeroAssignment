package com.DPDZero.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DPDZero.exception.UserException;
import com.DPDZero.model.User;
import com.DPDZero.service.UserService;


@RestController
@RequestMapping("/api")

public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PostMapping("/register")
	public ResponseEntity<Object> saveUserHandler(@Valid @RequestBody User user)throws UserException{	
		
		    
		        user.setPassword(passwordEncoder.encode(user.getPassword()));
		        User registeredUser = userService.registerUser(user);

		        Map<String, Object> responseData = new HashMap<>();
		        responseData.put("status", "success");
		        responseData.put("message", "User Successfully Registered");
		        responseData.put("data", registeredUser);
		        return ResponseEntity.ok().body(responseData);
		    
		}
}
