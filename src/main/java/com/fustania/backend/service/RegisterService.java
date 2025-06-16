package com.fustania.backend.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.fustania.backend.dto.RegisterRequest;
import com.fustania.backend.model.User;
import com.fustania.backend.repository.UserRepository;

@Service
public class RegisterService {
	  private final UserRepository userRepository;
	    private final PasswordEncoder passwordEncoder;

	    public RegisterService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
	        this.userRepository = userRepository;
	        this.passwordEncoder = passwordEncoder;
	    }

	    public User register(RegisterRequest request) {
	        if(userRepository.existsByEmail(request.getEmail())) {
	            throw new RuntimeException("Email already in use");
	        }

	        User user = new User();
	        user.setFirstName(request.getFirstName());
	        user.setLastName(request.getLastName());
	        user.setEmail(request.getEmail());
	        user.setPassword(passwordEncoder.encode(request.getPassword()));  
	        user.setRole(request.getRole());
	        user.setShteti(request.getShteti());

	        return userRepository.save(user);
	    }
}
