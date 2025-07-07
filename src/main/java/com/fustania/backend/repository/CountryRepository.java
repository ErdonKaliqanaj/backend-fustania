package com.fustania.backend.repository;

import com.fustania.backend.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, String> {
    Country findByName(String name);
}