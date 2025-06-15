package com.fustania.backend.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.fustania.backend.dto.RegisterRequest;
import com.fustania.backend.model.User;
import com.fustania.backend.repository.UserRepository;

@Service
public class UserService {
	private final UserRepository userRepository;
	 private final PasswordEncoder passwordEncoder;
	 
	 public UserService(UserRepository repo, PasswordEncoder encoder) {
		 this.userRepository = repo;
		 this.passwordEncoder = encoder;
	 }
	 
	 public void register(RegisterRequest req) {
		 User user = new User();
		 user.setEmri(req.getEmri());
		 user.setMbiemri(req.getMbiemri());
		 user.setEmail(req.getEmail());
		 user.setPassword(passwordEncoder.encode(req.getPassword()));
		 user.setShteti(req.getShteti());
		 user.setRoli(req.getRoli());
		 
		 userRepository.save(user);
	 }

}
