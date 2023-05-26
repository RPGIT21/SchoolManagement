package com.rp.management.service;

import java.lang.reflect.Array;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rp.management.model.Role;
import com.rp.management.model.User;
import com.rp.management.repository.UserRepository;
import com.rp.management.web.dto.UserRegistrationDto;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public User saveUser(UserRegistrationDto userRegistrationDto) {
		User user = new User(userRegistrationDto.getName(), userRegistrationDto.getEmail(),
				userRegistrationDto.getPassword(), Arrays.asList(new Role("ROLE_USER")) );
		
		return userRepository.save(user);
	}
	
}
