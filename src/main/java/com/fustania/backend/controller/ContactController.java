package com.fustania.backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fustania.backend.dto.ContactMessageRequest;
import com.fustania.backend.model.BuyUser;
import com.fustania.backend.model.ContactMessage;
import com.fustania.backend.model.Dress;
import com.fustania.backend.repository.BuyUserRepository;
import com.fustania.backend.repository.ContactMessageRepository;
import com.fustania.backend.repository.DressRepository;

@RestController
@RequestMapping("api/contact")
public class ContactController {
	private final ContactMessageRepository contactMessageRepository;
	private final DressRepository dressRepository;
	private final BuyUserRepository buyUserRepository;
	
	public ContactController(ContactMessageRepository contactMessageRepository,
			DressRepository dressRepository,
			BuyUserRepository  buyUserRepository) {
		this.contactMessageRepository = contactMessageRepository;
		this.dressRepository = dressRepository;
		this.buyUserRepository = buyUserRepository;
	}
	
	@PostMapping
	public ResponseEntity<ContactMessage> sendMessage(@RequestBody ContactMessageRequest request){
		
		Dress dress = dressRepository.findById(request.getDressId())
				.orElseThrow(() -> new RuntimeException("Dress not found"));
		BuyUser seller = buyUserRepository.findById(request.getSellerId())
				.orElseThrow(() -> new RuntimeException("Seller not found"));
		
		ContactMessage message = new ContactMessage();
		message.setName(request.getName());
		message.setEmail(request.getEmail());
		message.setMessage(request.getMessage());
        message.setOfferAmount(request.getOfferAmount());
        message.setDress(dress);
        message.setSeller(seller);

        ContactMessage savedMessage = contactMessageRepository.save(message);
        return ResponseEntity.ok(savedMessage);
	}
	
	
	

}
