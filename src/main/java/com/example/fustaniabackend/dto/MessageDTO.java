package com.example.fustaniabackend.dto;

import lombok.Data;

@Data
public class MessageDTO {
 private String senderName;
 private String senderEmail;
 private String content;
 private Long dressId;
 private Long sellerId;
}
