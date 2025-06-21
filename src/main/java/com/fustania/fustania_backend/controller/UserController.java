package com.fustania.fustania_backend.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fustania.fustania_backend.dto.UserResponse;
import com.fustania.fustania_backend.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;



@RestController("/api/users")
@RequestMapping
public class UserController {
    
 private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        List<UserResponse> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }
}
