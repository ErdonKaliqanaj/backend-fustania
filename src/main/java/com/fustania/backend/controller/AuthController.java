package com.fustania.backend.controller;

import com.fustania.backend.dto.RegisterRequest;
import com.fustania.backend.model.User;
import com.fustania.backend.service.RegisterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	private final RegisterService registerService;
	
	public AuthController(RegisterService registerService) {
		this.registerService = registerService;
	}
	
	@PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody RegisterRequest request) {
        try {
            return ResponseEntity.ok(registerService.register(request));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
	}

}
