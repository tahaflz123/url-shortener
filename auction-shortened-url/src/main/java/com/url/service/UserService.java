package com.url.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.url.entity.User;
import com.url.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	public Long signUp(User user) {
		 this.userRepository.save(user);
		 return user.getId();
	}


}
