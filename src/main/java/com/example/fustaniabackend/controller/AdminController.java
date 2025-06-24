package com.example.fustaniabackend.controller;

import com.example.fustaniabackend.dto.DressDTO;
import com.example.fustaniabackend.dto.UserDTO;

import com.example.fustaniabackend.service.DressService;
import com.example.fustaniabackend.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



import java.util.List;


@RestController
@RequestMapping("/api/admin")
public class AdminController {
 @Autowired
    private UserService userService;

    @Autowired
    private DressService dressService;

    @GetMapping("/clients")
    public ResponseEntity<List<UserDTO>> getAllClients() {
        List<UserDTO> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/publications")
    public ResponseEntity<List<DressDTO>> getAllPublications() {
        List<DressDTO> dresses = dressService.getAllDresses();
        return ResponseEntity.ok(dresses);
    }
}