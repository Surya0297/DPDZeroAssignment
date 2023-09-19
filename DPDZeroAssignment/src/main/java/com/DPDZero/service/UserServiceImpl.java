package com.DPDZero.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DPDZero.exception.UserException;
import com.DPDZero.model.User;
import com.DPDZero.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	
	@Autowired
	private UserRepository userRepo;
	
	@Override
	public User registerUser(User user)throws UserException {
		// TODO Auto-generated method stub
		return userRepo.save(user);
	}

}
