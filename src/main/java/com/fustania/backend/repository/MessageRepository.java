package com.fustania.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fustania.backend.model.Message;

public interface MessageRepository extends JpaRepository<Message, Long>{
List<Message> findBySellerId(Long sellerId);
}
