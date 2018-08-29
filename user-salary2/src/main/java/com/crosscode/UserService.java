package com.crosscode;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crosscode.repository.User;
import com.crosscode.repository.UserRepository;


/**
 * @author ankit.tripathi
 *
 */
@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	
	public List<User> getUser(){
		System.out.println((List<User>) userRepository.findAll());
		return (List<User>) userRepository.findAll();
		
	
		
	}

}
