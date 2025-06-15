package com.fustania.backendfustania.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.*;

import com.fustania.backendfustania.dto.RegisterRequest;
import com.fustania.backendfustania.service.UserService;



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
		System.out.println("Hyraaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		userService.register(request);
		return ResponseEntity.ok("Regjistrimi u krye me sukses");
	}
	

}
