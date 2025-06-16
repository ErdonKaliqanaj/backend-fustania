package com.fustania.backend.dto;

public class DressDetailsDto {
	 private String description;
	    private double price;
	    private String size;
	    private String photoUrl;
	    private String sellerFirstName;
	    private String sellerLastName;
	    private String sellerEmail;
	    private String sellerAddress;
	    
	    public String getDescription() {
	    	return description;
	    }
	    public void setDescription(String description) {
	    	this.description = description;
	    }
	    
	    public double getPrice() {
	    	return price;
	    }
	    public void setPrice(double price) {
	    	this.price = price;
	    }
	    
	    public String getSize() {
	    	return size;
	    }
	    public void setSize(String size) {
	    	this.size = size;
	    }
	    
	    public String getPhotoUrl() {
	    	return photoUrl;
	    }
	    public void setPhotoUrl(String photoUrl) {
	    	this.photoUrl = photoUrl;
	    }
	    
	    public String getSellerFirstName() {
	    	return sellerFirstName;
	    }
	    public void setSellerFirstName(String sellerFirstName) {
	    	this.sellerFirstName = sellerFirstName;
	    }
	    
	    public String getSellerLastName() {
	    	return sellerLastName;
	    }
	    public void setSellerLastName(String sellerLastName) {
	    	this.sellerLastName = sellerLastName;
	    }
	    
	    public String getSellerEmail() {
	    	return sellerEmail;
	    }
	    public void setSellerEmail(String sellerEmail) {
	    	this.sellerEmail = sellerEmail;
	    }
	    public String getsSellerAddress() {
	    	return sellerAddress;
	    }
	    public void setSellerAddress(String sellerAddress) {
	    	this.sellerAddress = sellerAddress;
	    }
}
