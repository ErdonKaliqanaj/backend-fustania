package com.example.fustaniabackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fustaniabackend.dto.MessageDTO;
import com.example.fustaniabackend.service.MessageService;

@RestController
@RequestMapping("/api/messages")
public class MessageContoller {

    @Autowired
    private MessageService messageService;

    @PostMapping
    public ResponseEntity<String> sendMessage(@RequestBody MessageDTO messageDTO){
        try{
            messageService.sendMessage(messageDTO);
            return ResponseEntity.ok("Message sent successfully");
        } catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
