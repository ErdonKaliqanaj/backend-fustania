package com.example.fustaniabackend.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Configuration;

@Configuration
public class CountryConfig {

    private List<String> allowedCountries = Arrays.asList("Kosovë", "Shqiperi", "Maqedoni");

    
    public List<String> getAllowedCountries() {
        return allowedCountries;
    }

    
    public void setAllowedCountries(List<String> countries) {
        this.allowedCountries = countries;
    }
}
