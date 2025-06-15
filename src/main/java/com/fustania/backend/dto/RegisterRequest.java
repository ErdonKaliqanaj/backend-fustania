package com.fustania.backend.dto;

import com.fustania.backend.model.Roli;
import com.fustania.backend.model.Shteti;

public class RegisterRequest {
    private String emri;
    private String mbiemri;
    private String email;
    private String password;
    private Shteti shteti;
    private Roli roli;

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
