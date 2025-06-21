package com.fustania.fustania_backend.dto;

import lombok.Data;



import jakarta.validation.constraints.*;

@Data
public class UserRequest {
 @NotBlank(message = "Emri nuk duhet të jetë bosh")
    private String firstName;

    @NotBlank(message = "Mbiemri nuk duhet të jetë bosh")
    private String lastName;

    @Email(message = "Email i pavlefshëm")
    @NotBlank(message = "Email nuk duhet të jetë bosh")
    private String email;

    @NotBlank(message = "Fjalëkalimi nuk duhet të jetë bosh")
    private String password;

    @NotBlank(message = "Adresa nuk duhet të jetë bosh")
    private String address;

    @NotNull(message = "Shteti është i detyrueshëm")
    private String shteti;

    @NotNull(message = "Roli është i detyr ESHTE I DETYRUAR")
    private String role;
}

