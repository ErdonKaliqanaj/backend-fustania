package com.fustania.fustania_backend.controller;

import com.fustania.fustania_backend.dto.LoginRequest;
import com.fustania.fustania_backend.dto.UserRequest;
import com.fustania.fustania_backend.dto.UserResponse;
import com.fustania.fustania_backend.service.UserService;
import io.jsonwebtoken.JwtClaimsSet;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.MacAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;

    @Value("${jwt.secret}")
    private String jwtSecret;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@Valid @RequestBody UserRequest userRequest) {
        UserResponse userResponse = userService.registerUser(userRequest);
        return ResponseEntity.ok(userResponse);
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@Valid @RequestBody LoginRequest loginRequest) {
        userService.findByEmail(loginRequest.getEmail())
                .filter(user -> user.getPassword().equals(loginRequest.getPassword()))
                .orElseThrow(() -> new RuntimeException("Invalid credentials"));

        // Dekodojmë Base64 secret në bytes
        byte[] keyBytes = Base64.getDecoder().decode(jwtSecret);
        Key key = Keys.hmacShaKeyFor(keyBytes);

        // Krijojmë claims me Instant
        JwtClaimsSet claims = JwtClaimsSet.builder()
                .subject(loginRequest.getEmail())
                .issuedAt(new Date().toInstant())
                .expiration(new Date(System.currentTimeMillis() + 86400000).toInstant()) // 24h expiration
                .build();

        // Ndërtojmë tokenin
        String token = Jwts.builder()
                .setClaims(claims)
                .signWith(key, MacAlgorithm.HS256)
                .compact();

        Map<String, String> response = new HashMap<>();
        response.put("token", token);
        return ResponseEntity.ok(response);
    }
}
