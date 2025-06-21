package com.fustania.fustania_backend.controller;

import com.fustania.fustania_backend.dto.MessageRequest;
import com.fustania.fustania_backend.dto.MessageResponse;
import com.fustania.fustania_backend.service.MessageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping
    public ResponseEntity<MessageResponse> sendMessage(@RequestBody MessageRequest messageRequest) {
        MessageResponse messageResponse = messageService.sendMessage(messageRequest);
        return ResponseEntity.ok(messageResponse);
    }
}