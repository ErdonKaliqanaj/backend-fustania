package com.fustania.backend.model;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
public class ContactMessage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	@Column(nullable = false)
	private String email;
	
	@Column(columnDefinition = "TEXT")
	private String message;
	
	private Double offerAmount;
	
	@ManyToOne
	@JoinColumn(name = "seller_id")
	private BuyUser seller;
	
	@ManyToOne
	@JoinColumn(name = "dress_id")
	private Dress dress;
	
	private LocalDateTime createdAt = LocalDateTime.now();
	
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
	this.message = message;
}
	
    public Double getOfferAmount() {	
    	return offerAmount;
    }
    public void setOfferAmount(Double offerAmount) { 
        this.offerAmount = offerAmount;
    }
    
    public BuyUser getSeller() {
    	return seller;
    }
    public void setSeller(BuyUser seller) {
    	this.seller = seller;
    }
    
    public Dress getDress() {
    	return dress;
    }
    public void setDress(Dress dress) {
    this.dress = dress;
    }
    
    public LocalDateTime getCreatedAt() {
    	return createdAt;
    }
}