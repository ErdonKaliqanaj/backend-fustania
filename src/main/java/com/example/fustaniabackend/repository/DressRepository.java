package com.example.fustaniabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.fustaniabackend.entity.Dress;

import java.util.List;

@Repository
public interface DressRepository extends JpaRepository<Dress, Long> {
    List<Dress> findBySellerId(Long sellerId);

    @Query("SELECT d FROM Dress d WHERE " + 
    "(:priceMin IS NULL OR d.price >= :priceMin) AND " +
    " (:priceMax IS NULL OR d.price <= :priceMax) AND " +
    "(:size IS NULL OR d.size = :size) AND " +
    "(:color IS NULL OR d.color = :color)")

    List<Dress> findByFilters(
        @Param("priceMin") Double priceMan,
        @Param("priceMax")Double priceMax,
        @Param("size") String size,
        @Param("color")String color
    );
}
