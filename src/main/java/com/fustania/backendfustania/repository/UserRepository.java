package com.fustania.backendfustania.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fustania.backendfustania.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
   Optional<User> findByEmail(String email);
}