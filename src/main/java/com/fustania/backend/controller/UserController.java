package com.fustania.backend.controller;

import com.fustania.backend.dto.DressDTO;
import com.fustania.backend.dto.MessageDTO;
import com.fustania.backend.dto.UserDTO;
import com.fustania.backend.service.DressService;
import com.fustania.backend.service.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/users")
public class UserController {
 @Autowired
    private UserService userService;

   @Autowired
    private DressService dressService;

   @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserDTO userDTO) {
        userService.registerUser(userDTO);
        return ResponseEntity.ok("User registered successfully");
    }
  @GetMapping("/me")
    public ResponseEntity<UserDTO> getCurrentUser(@RequestParam Long userId) {
        UserDTO userDTO = userService.getUserById(userId);
        return ResponseEntity.ok(userDTO);
    }

    @PutMapping("/me")
    public ResponseEntity<String> updateUser(@RequestParam Long userId, @RequestBody UserDTO userDTO) {
        userService.updateUser(userId, userDTO);
        return ResponseEntity.ok("User updated successfully");
    }

    @GetMapping("/me/dresses")
    public ResponseEntity<List<DressDTO>> getUserDresses(@RequestParam Long userId) {
        List<DressDTO> dresses = dressService.getDressesBySellerId(userId);
        return ResponseEntity.ok(dresses);
    }

    @GetMapping("/me/messages")
    public ResponseEntity<List<MessageDTO>> getUserMessages(@RequestParam Long userId) {
        List<MessageDTO> messages = dressService.getMessagesBySellerId(userId);
        return ResponseEntity.ok(messages);
    }
}