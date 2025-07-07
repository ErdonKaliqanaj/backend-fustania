/*
package com.fustania.backend.service;

import com.fustania.backend.dto.UserDTO;
import com.fustania.backend.exception.InvalidUserDataException;
import com.fustania.backend.model.User;
import com.fustania.backend.model.Country;
import com.fustania.backend.repository.UserRepository;
import com.fustania.backend.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CountryRepository countryRepository;

    public void registerUser(UserDTO userDTO) {
        if (userDTO.getFirstName() == null || userDTO.getFirstName().isEmpty()) {
            throw new InvalidUserDataException("First name is required");
        }
        if (!userDTO.getFirstName().matches("^[a-zA-Z]+$")) {
            throw new InvalidUserDataException("First name must contain only letters");
        }
        if (userDTO.getLastName() == null || userDTO.getLastName().isEmpty()) {
            throw new InvalidUserDataException("Last name is required");
        }
        if (!userDTO.getLastName().matches("^[a-zA-Z]+$")) {
            throw new InvalidUserDataException("Last name must contain only letters");
        }
        if (userDTO.getEmail() == null || userDTO.getEmail().isEmpty()) {
            throw new InvalidUserDataException("Email is required");
        }
        if (!userDTO.getEmail().matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            throw new InvalidUserDataException("Invalid email format");
        }
        if (userDTO.getPassword() == null || userDTO.getPassword().isEmpty()) {
            throw new InvalidUserDataException("Password is required");
        }
        if (!userDTO.getPassword().matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$")) {
            throw new InvalidUserDataException("Password must be at least 8 characters long and contain at least one number, one uppercase letter, and one lowercase letter");
        }
        if (userDTO.getCountryName() == null || userDTO.getCountryName().isEmpty()) {
            throw new InvalidUserDataException("Country is required");
        }
        if (userDTO.getRole() == null || userDTO.getRole().isEmpty()) {
            throw new InvalidUserDataException("Role is required");
        }
        if (!userDTO.getRole().equals("BUYER") && !userDTO.getRole().equals("SELLER")) {
            throw new InvalidUserDataException("Invalid role");
        }
        if (userDTO.getAddress() == null || userDTO.getAddress().isEmpty()) {
            throw new InvalidUserDataException("Address is required");
        }

        Country country = countryRepository.findByName(userDTO.getCountryName());
        if (country == null) {
            throw new InvalidUserDataException("Invalid country");
        }

        if (userRepository.findByEmail(userDTO.getEmail()).isPresent()) {
            throw new InvalidUserDataException("Email is already registered");
        }

        User user = new User();
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword()); // Në prodhim, përdor hash për fjalëkalimin
        user.setCountry(country);
        user.setRole(User.Role.valueOf(userDTO.getRole()));
        user.setAddress(userDTO.getAddress());

        userRepository.save(user);
    }
}
*/

package com.fustania.backend.service;

import com.fustania.backend.dto.UserDTO;
import com.fustania.backend.exception.InvalidUserDataException;
import com.fustania.backend.model.User;
import com.fustania.backend.model.Country;
import com.fustania.backend.repository.UserRepository;
import com.fustania.backend.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CountryRepository countryRepository;

    public void registerUser(UserDTO userDTO) {
        if (userDTO.getFirstName() == null || userDTO.getFirstName().isEmpty()) {
            throw new InvalidUserDataException("First name is required");
        }
        if (!userDTO.getFirstName().matches("^[a-zA-Z]+$")) {
            throw new InvalidUserDataException("First name must contain only letters");
        }
        if (userDTO.getLastName() == null || userDTO.getLastName().isEmpty()) {
            throw new InvalidUserDataException("Last name is required");
        }
        if (!userDTO.getLastName().matches("^[a-zA-Z]+$")) {
            throw new InvalidUserDataException("Last name must contain only letters");
        }
        if (userDTO.getEmail() == null || userDTO.getEmail().isEmpty()) {
            throw new InvalidUserDataException("Email is required");
        }
        if (!userDTO.getEmail().matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            throw new InvalidUserDataException("Invalid email format");
        }
        if (userDTO.getPassword() == null || userDTO.getPassword().isEmpty()) {
            throw new InvalidUserDataException("Password is required");
        }
        if (!userDTO.getPassword().matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$")) {
            throw new InvalidUserDataException("Password must be at least 8 characters long and contain at least one number, one uppercase letter, and one lowercase letter");
        }
        if (userDTO.getCountryName() == null || userDTO.getCountryName().isEmpty()) {
            throw new InvalidUserDataException("Country is required");
        }
        if (userDTO.getRole() == null || userDTO.getRole().isEmpty()) {
            throw new InvalidUserDataException("Role is required");
        }
        if (!userDTO.getRole().equals("BUYER") && !userDTO.getRole().equals("SELLER")) {
            throw new InvalidUserDataException("Invalid role");
        }
        if (userDTO.getAddress() == null || userDTO.getAddress().isEmpty()) {
            throw new InvalidUserDataException("Address is required");
        }

        Country country = countryRepository.findByName(userDTO.getCountryName());
        if (country == null) {
            throw new InvalidUserDataException("Invalid country");
        }

        if (userRepository.findByEmail(userDTO.getEmail()).isPresent()) {
            throw new InvalidUserDataException("Email is already registered");
        }

        User user = new User();
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setCountry(country);
        user.setRole(User.Role.valueOf(userDTO.getRole()));
        user.setAddress(userDTO.getAddress());

        userRepository.save(user);
    }

    public UserDTO getUserById(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new InvalidUserDataException("User not found"));
        UserDTO userDTO = new UserDTO();
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setEmail(user.getEmail());
        userDTO.setCountryName(user.getCountry().getName());
        userDTO.setRole(user.getRole().toString());
        userDTO.setAddress(user.getAddress());
        return userDTO;
    }

    public void updateUser(Long userId, UserDTO userDTO) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new InvalidUserDataException("User not found"));

        if (userDTO.getFirstName() != null && !userDTO.getFirstName().isEmpty()) {
            if (!userDTO.getFirstName().matches("^[a-zA-Z]+$")) {
                throw new InvalidUserDataException("First name must contain only letters");
            }
            user.setFirstName(userDTO.getFirstName());
        }
        if (userDTO.getLastName() != null && !userDTO.getLastName().isEmpty()) {
            if (!userDTO.getLastName().matches("^[a-zA-Z]+$")) {
                throw new InvalidUserDataException("Last name must contain only letters");
            }
            user.setLastName(userDTO.getLastName());
        }
        if (userDTO.getEmail() != null && !userDTO.getEmail().isEmpty()) {
            if (!userDTO.getEmail().matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
                throw new InvalidUserDataException("Invalid email format");
            }
            if (userRepository.findByEmail(userDTO.getEmail()).isPresent() && !userDTO.getEmail().equals(user.getEmail())) {
                throw new InvalidUserDataException("Email is already registered");
            }
            user.setEmail(userDTO.getEmail());
        }
        if (userDTO.getPassword() != null && !userDTO.getPassword().isEmpty()) {
            if (!userDTO.getPassword().matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$")) {
                throw new InvalidUserDataException("Password must be at least 8 characters long and contain at least one number, one uppercase letter, and one lowercase letter");
            }
            user.setPassword(userDTO.getPassword());
        }
        if (userDTO.getCountryName() != null && !userDTO.getCountryName().isEmpty()) {
            Country country = countryRepository.findByName(userDTO.getCountryName());
            if (country == null) {
                throw new InvalidUserDataException("Invalid country");
            }
            user.setCountry(country);
        }
        if (userDTO.getAddress() != null && !userDTO.getAddress().isEmpty()) {
            user.setAddress(userDTO.getAddress());
        }

        userRepository.save(user);
    }
}