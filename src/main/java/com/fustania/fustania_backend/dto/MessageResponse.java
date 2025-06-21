package com.fustania.fustania_backend.dto;



import lombok.Data;

@Data
public class MessageResponse {
  private Long id;
  private String content;
  private Double offerPrice;
  private String senderEmail;
  private String senderName;
  private Long dressId;
  private Long sellerId;
   

}
