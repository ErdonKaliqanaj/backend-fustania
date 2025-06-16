package com.fustania.backend.dto;

import com.fustania.backend.model.User;
import com.fustania.backend.model.User.Country;
import com.fustania.backend.model.User.Role;

public class RegisterRequest {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private User.Country shteti;
    private User.Role role;

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

    public String getEmail(){
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public User.Role getRole() {
        return role;
    }
    public void setRole(User.Role role) {
        this.role = role;
    }

    public User.Country getShteti() {
        return shteti;
    }
    public void setShteti(User.Country shteti) {
        this.shteti = shteti;
    }
}

