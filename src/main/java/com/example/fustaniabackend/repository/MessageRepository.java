package com.example.fustaniabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.fustaniabackend.entity.Message;

public interface MessageRepository extends JpaRepository<Message, Long>{

}
