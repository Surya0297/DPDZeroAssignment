package com.DPDZero.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.DPDZero.model.User;
import com.DPDZero.repository.UserRepository;




@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private UserRepository userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		
		Optional<User> opt=userRepo.findByUsername(username);

		if(opt.isPresent()) {
			
			User user= opt.get();
			
			List<GrantedAuthority> authorities= new ArrayList<>();
			//authorities.add(new SimpleGrantedAuthority(customer.getRole()));
			
			return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
			
			
			
			
		}else
			throw new BadCredentialsException("User Details not found with this username: "+username);
		
		
		
		
		
	}
	
	
}
