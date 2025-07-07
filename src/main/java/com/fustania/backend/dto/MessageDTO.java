package com.fustania.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageDTO {
private String senderEmail;
    private String content;
    private Double offerPrice;
    private Long dressId;
    private Long sellerId;
}
