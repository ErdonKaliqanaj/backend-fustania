package com.fustania.backend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "buy_users")
public class BuyUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Emri është i detyrueshëm")
    private String firstName;

    @NotBlank(message = "Mbiemri është i detyrueshëm")
    private String lastName;

    @Email(message = "Email-i nuk është i vlefshëm")
    @NotBlank(message = "Email-i është i detyrueshëm")
    @Column(unique = true)
    private String email;

    @NotBlank(message = "Fjalëkalimi është i detyrueshëm")
    @JsonIgnore
    private String password;

    @NotBlank(message = "Adresa është e detyrueshme")
    private String address;
    @Enumerated(EnumType.STRING)
    private User.Country shteti = User.Country.KOSOVE;

    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @JsonIgnore
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public User.Country getShteti() {
        return shteti;
    }

    public void setShteti(User.Country shteti) {
        this.shteti = shteti;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
