package com.fustania.fustania_backend.service;

import com.fustania.fustania_backend.dto.MessageRequest;
import com.fustania.fustania_backend.dto.MessageResponse;
import com.fustania.fustania_backend.model.Dress;
import com.fustania.fustania_backend.model.Message;
import com.fustania.fustania_backend.model.User;
import com.fustania.fustania_backend.repository.DressRepository;
import com.fustania.fustania_backend.repository.MessageRepository;
import com.fustania.fustania_backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MessageService {

    private final MessageRepository messageRepository;
    private final UserRepository userRepository;
    private final DressRepository dressRepository;

    public MessageService(MessageRepository messageRepository, UserRepository userRepository, DressRepository dressRepository) {
        this.messageRepository = messageRepository;
        this.userRepository = userRepository;
        this.dressRepository = dressRepository;
    }

    public MessageResponse sendMessage(MessageRequest messageRequest) {
        Optional<User> seller = userRepository.findById(messageRequest.getSellerId());
        Optional<Dress> dress = dressRepository.findById(messageRequest.getDressId());
        if (seller.isEmpty() || dress.isEmpty()) {
            throw new RuntimeException("Seller or Dress not found");
        }

        Message message = new Message();
        message.setContent(messageRequest.getContent());
        message.setOfferPrice(messageRequest.getOfferPrice());
        message.setSenderName(messageRequest.getSenderName());
        message.setSenderEmail(messageRequest.getSenderEmail());
        message.setSeller(seller.get());
        message.setDress(dress.get());

        Message savedMessage = messageRepository.save(message);
        return mapToMessageResponse(savedMessage);
    }

    private MessageResponse mapToMessageResponse(Message message) {
        MessageResponse response = new MessageResponse();
        response.setId(message.getId());
        response.setContent(message.getContent());
        response.setOfferPrice(message.getOfferPrice());
        response.setSenderName(message.getSenderName());
        response.setSenderEmail(message.getSenderEmail());
        response.setDressId(message.getDress().getId());
        response.setSellerId(message.getSeller().getId());
        return response;
    }
}