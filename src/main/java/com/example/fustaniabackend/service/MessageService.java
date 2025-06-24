package com.example.fustaniabackend.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fustaniabackend.dto.MessageDTO;
import com.example.fustaniabackend.entity.Message;
import com.example.fustaniabackend.entity.User;
import com.example.fustaniabackend.repository.MessageRepository;
import com.example.fustaniabackend.repository.UserRepository;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private UserRepository userRepository; 

    public void sendMessage(MessageDTO messageDTO){
        User seller = userRepository.findById(messageDTO.getSellerId())
        .orElseThrow(() -> new IllegalArgumentException("Seller not found woth ID: " + messageDTO.getSellerId()));

        Message message = new Message();
        message.setSenderName(messageDTO.getSenderName());
        message.setSenderEmail(messageDTO.getSenderEmail());
        message.setContent(messageDTO.getContent());
        message.setDressId(messageDTO.getDressId());
        message.setSeller(seller);
        message.setSentAt(LocalDateTime.now());

        messageRepository.save(message);
    }
}
