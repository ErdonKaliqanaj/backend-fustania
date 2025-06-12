package com.fustania.backendfustania.model;
import org.hibernate.validator.constraints.Email;
import org.springframework.data.annotation.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Emri është i detyrueshëm")
    @Size(min = 2, max = 50, message = "Emri duhet të jetë midis 2 dhe 50 karaktere")
    private String emri;

    @NotBlank(message = "Mbiemri është i detyrueshëm")
    @Size(min = 2, max = 50, message = "Mbiemri duhet të jetë midis 2 dhe 50 karaktere")
    private String mbiemri;

    @NotBlank(message = "Email është i detyrueshëm")
    @Email(message = "Email nuk është i vlefshëm")
    @Column(unique = true)
    private String email;

    @jakarta.validation.constraints.NotBlank(message = "Fjalëkalimi është i detyrueshëm")
    @Size(min = 6, message = "Fjalëkalimi duhet të jetë të paktën 6 karaktere")
    private String password;

    @Enumerated(EnumType.STRING)
    @NotBlank(message = "Shteti është i detyrueshëm")
    private Shteti shteti;

    public enum Shteti {
        KOSOVE // Fillimisht vetëm Kosova
        // Më vonë mund të shtohen: , SHQIPERI, MAQEDONI
    }

    // Getters dhe Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmri() {
        return emri;
    }

    public void setEmri(String emri) {
        this.emri = emri;
    }

    public String getMbiemri() {
        return mbiemri;
    }

    public void setMbiemri(String mbiemri) {
        this.mbiemri = mbiemri;
    }

    public String getEmail() {
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

    public Shteti getShteti() {
        return shteti;
    }

    public void setShteti(Shteti shteti) {
        this.shteti = shteti;
    }
}