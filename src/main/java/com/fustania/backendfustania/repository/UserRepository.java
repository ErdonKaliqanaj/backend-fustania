package com.fustania.backendfustania.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fustania.backendfustania.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);
}