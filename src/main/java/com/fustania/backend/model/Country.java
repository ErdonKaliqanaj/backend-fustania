package com.fustania.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="countries")
public class Country {

    @Id
    private Long id;
    private String name;

}
