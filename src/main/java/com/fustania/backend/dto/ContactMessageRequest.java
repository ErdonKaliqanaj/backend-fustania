package com.fustania.backend.dto;

public class ContactMessageRequest {
	private String name;
    private String email;
    private String message;
    private Double offerAmount;
    private Long dressId;
    private Long sellerId;
    
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

    public Long getDressId() {
        return dressId;
    }

    public void setDressId(Long dressId) {
        this.dressId = dressId;
    }

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }
}
