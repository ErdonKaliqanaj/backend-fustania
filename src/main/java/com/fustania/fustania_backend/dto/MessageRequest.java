package com.fustania.fustania_backend.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

@Data
public class MessageRequest {
  @NotBlank
  private String content;

  @PositiveOrZero
  private Double offerPrice;

  @NotBlank
  @Email
  private String senderEmail;

  @NotBlank
  private String senderName;

  @NotNull
  private Long dressId;

  @NotNull(message = "Seller ID is required")
  private Long sellerId;
}
