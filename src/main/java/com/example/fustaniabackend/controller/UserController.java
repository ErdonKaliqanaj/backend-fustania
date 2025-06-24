package com.example.fustaniabackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fustaniabackend.dto.UserDTO;
import com.example.fustaniabackend.dto.UserRegistrationDTO;
import com.example.fustaniabackend.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

     @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserDTO> register(@RequestBody UserRegistrationDTO registrationDTO) {
        UserDTO userDTO = userService.registerUser(registrationDTO);
        return ResponseEntity.ok(userDTO);
    }
}
