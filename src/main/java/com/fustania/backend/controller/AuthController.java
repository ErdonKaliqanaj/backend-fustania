package com.fustania.backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.fustania.backend.dto.RegisterRequest;
import com.fustania.backend.service.UserService;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {
private final UserService userService;
	
	public AuthController(UserService service) {
		this.userService = service;
	}
	
	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody RegisterRequest request){
		
		userService.register(request);
		return ResponseEntity.ok("Regjistrimi u krye me sukses");
	}
}
