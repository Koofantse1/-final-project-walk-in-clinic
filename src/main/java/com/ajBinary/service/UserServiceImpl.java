package com.ajBinary.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ajBinary.entity.User;
import com.ajBinary.repo.UserRepo;
@Service
public class UserServiceImpl implements UserDetailsService{ 
	@Autowired
	private UserRepo userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) 
			throws UsernameNotFoundException {
		Optional<User> userOpt = 
				userRepo.findByUsername(username);
		UserBuilder builder = null;
		if(userOpt.isPresent()) {
			User currentUser = userOpt.get();
			builder = org.springframework.security.core
					.userdetails.User.withUsername(username);
			builder.password(currentUser.getPassword());
			builder.roles(currentUser.getRole());
			return builder.build();
		}else {
			throw new UsernameNotFoundException("user not found");
		}
	}

}

	
	


