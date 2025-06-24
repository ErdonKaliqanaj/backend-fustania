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
@RequestMapping("/api/client")
public class ClientController {

     @Autowired
    private UserService userService;

    @Autowired
    private DressService dressService;

    @GetMapping("/profile")
    public ResponseEntity<UserDTO> getProfile(@RequestParam String email) {
        UserDTO userDTO = userService.getUserProfile(email);
        return ResponseEntity.ok(userDTO);
    }

    @GetMapping("/publications")
    public ResponseEntity<List<DressDTO>> getPublications(@RequestParam Long sellerId) {
        List<DressDTO> dresses = dressService.getAllDresses();
        return ResponseEntity.ok(dresses);
    }
}
