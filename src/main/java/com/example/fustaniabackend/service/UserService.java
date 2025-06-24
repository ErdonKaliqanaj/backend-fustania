package com.example.fustaniabackend.service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.fustaniabackend.config.CountryConfig;
import com.example.fustaniabackend.dto.UserDTO;
import com.example.fustaniabackend.dto.UserRegistrationDTO;
import com.example.fustaniabackend.entity.User;
import com.example.fustaniabackend.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private CountryConfig countryConfig;

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    public UserDTO registerUser(UserRegistrationDTO registrationDTO){
        logger.info("Attempting to register user with email: {}", registrationDTO.getEmail());

        if (!countryConfig.getAllowedCountries().contains(registrationDTO.getCountry())) {
            throw new IllegalArgumentException("Invalid country");
            
        }

        if (!List.of("SELLER", "BUYER").contains(registrationDTO.getRole())) {
            logger.error("Invalid role: {}", registrationDTO.getRole());
            throw new IllegalArgumentException("Invalid role");
            
        }

        logger.debug("Checking if email exists: {}", registrationDTO.getEmail());
        User existingUser = userRepository.findByEmail(registrationDTO.getEmail());
        if (existingUser != null) {
            logger.warn("Email already exists: {}", registrationDTO.getEmail());
            throw new RuntimeException("Email alreadt exists");
            
        }

        User user = new User();
        user.setFirstName(registrationDTO.getFirstName());
        user.setLastName(registrationDTO.getLastName());
        user.setEmail(registrationDTO.getEmail());
        user.setPassword(passwordEncoder.encode(registrationDTO.getPassword()));
        user.setCountry(registrationDTO.getCountry());
        user.setRole(User.Role.valueOf(registrationDTO.getRole()));

        logger.debug("Saving user: {}", user.getEmail());
        user = userRepository.save(user);
        logger.info("User registered successfully: {}", user.getEmail());
        return mapToDTO(user);
    }

    public UserDTO getUserProfile(String email) {
        logger.debug("Fetching user profile for email: {}", email);
        User user = userRepository.findByEmail(email);
        if (user == null) {
            logger.warn("User not found: {}", email);
            throw new RuntimeException("User not found");
        }
        return mapToDTO(user);
    }

    public List<UserDTO> getAllUsers() {
        logger.debug("Fetching all users");
        return userRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    private UserDTO mapToDTO(User user) {
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setEmail(user.getEmail());
        dto.setCountry(user.getCountry());
        dto.setRole(user.getRole().name());
        return dto;
    }
}