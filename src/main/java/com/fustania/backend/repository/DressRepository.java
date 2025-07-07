package com.fustania.backend.repository;

import com.fustania.backend.model.Dress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DressRepository extends JpaRepository<Dress, Long> {
    List<Dress> findByCategory(String category);
    List<Dress> findByCountryName(String countryName);
    List<Dress> findByPriceLessThanEqual(double maxPrice);
    List<Dress> findBySize(String size);
    List<Dress> findByColor(String color);
    List<Dress> findByCity(String city);
    @Query("SELECT d FROM Dress d WHERE CONCAT(d.seller.firstName, ' ', d.seller.lastName) LIKE %:sellerName%")
    List<Dress> findBySellerNameContaining(String sellerName);
    List<Dress> findBySellerId(Long sellerId);
}
