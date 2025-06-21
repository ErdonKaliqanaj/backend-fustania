package com.fustania.fustania_backend.model;



import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;


@Entity
@Table(name = "users")
@Data
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Emri nuk duhet të jetë bosh")
    private String firstName;

    @NotBlank(message = "Mbiemri nuk duhet të jetë bosh")
    private String lastName;

    @Email(message = "Email i pavlefshëm")
    @NotBlank(message = "Email nuk duhet të jetë bosh")
    @Column(unique = true)
    private String email;

    @NotBlank(message = "Fjalëkalimi nuk duhet të jetë bosh")
    private String password;

    @NotBlank(message = "Adresa nuk duhet të jetë bosh")
    private String address;

   
    @NotNull(message = "Shteti është i detyrueshëm")
    private String shteti;

    
    @NotNull(message = "Roli është i detyrueshëm")
    private String role;
}
