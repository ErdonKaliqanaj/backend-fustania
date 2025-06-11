package com.fustania.backendfustania.controller;

import com.fustania.backendfustania.dto.RegisterRequest;
import com.fustania.backendfustania.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AuthController {
	
	private final AuthService authService;
	
	@PostMapping("/register")
	public ResponseEntity<?> register(@Valid @RequestBody RegisterRequest request){
		authService.register(request);
		return ResponseEntity.ok("User registered successfully");
	}

}
