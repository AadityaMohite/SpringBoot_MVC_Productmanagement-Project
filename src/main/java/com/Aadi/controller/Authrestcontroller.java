package com.Aadi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Aadi.entity.User;
import com.Aadi.repo.UserRepository;

@RestController
@RequestMapping("/auth")
public class Authrestcontroller {

	private final BCryptPasswordEncoder encoder;
	
	public Authrestcontroller(BCryptPasswordEncoder encoder) {
		this.encoder = encoder;
	}
	
	
	@Autowired
public 	UserRepository userRepository;
	
	@PostMapping("/saveuser")
	public ResponseEntity<User> saveuser(@RequestBody User user){
		
		
		user.setPassword(encoder.encode(user.getPassword()));
		
		if(user.getUsername().equals("Aadi")||user.getUsername().equals("Raj")) {
			
			user.setRole("ADMIN");
		}else {
			user.setRole("USER");
		}
		
		
		
		User saveUser = userRepository.save(user);
		
		
		return new ResponseEntity<User>(saveUser,HttpStatus.OK);
		
		
		
		

	}
	
	
	
	
	
	
	
}
