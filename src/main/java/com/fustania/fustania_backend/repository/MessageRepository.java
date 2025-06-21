package com.fustania.fustania_backend.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.fustania.fustania_backend.model.Message;

public interface MessageRepository extends JpaRepository<Message, Long>{

}