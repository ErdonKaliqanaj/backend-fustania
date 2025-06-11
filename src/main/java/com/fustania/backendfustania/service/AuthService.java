package com.fustania.backendfustania.service;

import com.fustania.backendfustania.dto.RegisterRequest;
import com.fustania.backendfustania.model.User;
import com.fustania.backendfustania.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	
	public void register(RegisterRequest request) {
		if(userRepository.findByEmail(request.getEmail()).isPresent()) {
			throw new IllegalArgumentException("this email allready exists");
		}
		User.Country country = request.getCountry() !=null ? request.getCountry() : User.Country.KOSOVA;
		
		User user = User.builder()
				.name(request.getName())
				.surname(request.getSurname())
				.email(request.getEmail())
				.password(passwordEncoder.encode(request.getPassword()))
				.country(country)
				.role(request.getRole())
				.build();
		
		userRepository.save(user);
	}
}
