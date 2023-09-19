package com.DPDZero.service;

import java.sql.SQLIntegrityConstraintViolationException;

import com.DPDZero.exception.UserException;
import com.DPDZero.model.User;

public interface UserService {
	public User registerUser(User user)throws UserException;
	
}
