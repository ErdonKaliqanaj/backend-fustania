package com.fustania.fustania_backend.dto;



import lombok.Data;

@Data
public class UserResponse {
 private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String shteti;
    private String role;

    
}
