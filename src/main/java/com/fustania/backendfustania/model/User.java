package com.fustania.backendfustania.model;

import jakarta.persistence.*;


@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   
    private String emri;
    private String mbiemri;

    
    @Column(unique = true, nullable = false)
    private String email;



    
    private String password;

   @Enumerated(EnumType.STRING)
    private Shteti shteti;
    
    @Enumerated(EnumType.STRING)
    private Roli roli ;
  

    
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
    public Roli getRoli() {
    	return roli;
    }
    public void setRoli(Roli roli) {
    	this.roli = roli;
    }
}


