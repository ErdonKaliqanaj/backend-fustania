package com.fustania.backendfustania.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fustania.backendfustania.model.Dress;

public interface DressRepository extends JpaRepository<Dress, Long> {
    @Query("SELECT d FROM Dress d WHERE (:title IS NULL OR d.title LIKE %:title%) " +
           "AND (:dizajneri IS NULL OR d.dizajneri LIKE %:dizajneri%) " +
           "AND (:cmimi IS NULL OR d.cmimi <= :cmimi) " +
           "AND (:ngjyra IS NULL OR d.ngjyra LIKE %:ngjyra%) " +
           "AND (:shteti IS NULL OR d.shteti LIKE %:shteti%) " +
           "AND (:qyteti IS NULL OR d.qyteti LIKE %:qyteti%)")
    List<Dress> findByFilters(String title, String dizajneri, Double cmimi, String ngjyra, String shteti, String qyteti);
}
