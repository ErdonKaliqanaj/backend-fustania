package com.fustania.backendfustania.dto.auth;

import com.fustania.backendfustania.model.User.Country;
import com.fustania.backendfustania.model.User.Role;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
 
	@NotBlank
	private String name;
	
	@NotBlank
	private String surname;
	
	@Email
	@NotBlank
	private String email;
	
	@NotBlank
	private String password;
	
	private Country country;
	
	private Role role;
}
