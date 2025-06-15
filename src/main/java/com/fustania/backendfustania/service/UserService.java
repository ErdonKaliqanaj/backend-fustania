package com.fustania.backendfustania.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.fustania.backendfustania.dto.RegisterRequest;
import com.fustania.backendfustania.model.User;
import com.fustania.backendfustania.repository.UserRepository;

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
	 user.setEmri(req.emri);
	 user.setMbiemri(req.mbiemri);
	 user.setEmail(req.email);
	 user.setPassword(passwordEncoder.encode(req.password));
	 user.setShteti(req.shteti);
	 user.setRoli(req.roli);
	 
	 userRepository.save(user);
 }
}