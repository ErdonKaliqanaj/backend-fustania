package com.fustania.backend.config;

import com.fustania.backend.model.BuyUser;
import com.fustania.backend.model.Dress;
import com.fustania.backend.repository.BuyUserRepository;
import com.fustania.backend.repository.DressRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {
    @Bean
    CommandLineRunner initData(BuyUserRepository buyUserRepository, DressRepository dressRepository) {
        return args -> {
           
            BuyUser seller = new BuyUser();
            seller.setFirstName("Ana");
            seller.setLastName("Shala");
            seller.setEmail("ana@example.com");
            seller.setPassword("password123");
            seller.setAddress("Prishtinë, Rruga B, Nr. 10");
            buyUserRepository.save(seller);

            
            Dress dress = new Dress();
            dress.setDescription("Fustan elegant i bardhë për dasma");
            dress.setPrice(150.00);
            dress.setSize("M");
            dress.setPhotoUrl("https://example.com/dress1.jpg");
            dress.setSeller(seller);
            dressRepository.save(dress);
        };
    }
}