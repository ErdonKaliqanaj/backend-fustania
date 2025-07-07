package com.fustania.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fustania.backend.model.Country;
import com.fustania.backend.repository.CountryRepository;

@Service
public class CountryService {
@Autowired
    private CountryRepository countryRepository;

    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }
}
