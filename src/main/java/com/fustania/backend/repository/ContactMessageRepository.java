package com.fustania.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fustania.backend.model.ContactMessage;

public interface ContactMessageRepository extends JpaRepository<ContactMessage, Long>{

}
