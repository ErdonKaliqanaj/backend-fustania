package com.fustania.backend.dto;

import lombok.Data;

@Data
public class UserDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String countryName;
    private String role;
    private String address;

}
