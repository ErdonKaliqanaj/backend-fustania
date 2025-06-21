package com.fustania.fustania_backend.model;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;
@Entity
@Table(name="messages")
@Data
public class Message {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank(message = "Message content is required")
  @Column(columnDefinition = "TEXT")
  private String content;

  @PositiveOrZero(message = "Offer price must be positive")
  private Double offerPrice;

  @NotBlank(message = "Sender email is required")
  @Email(message = "Invalid email format")
  private String senderEmail;

  @NotBlank(message = "Sender name is required")
  private String senderName;

  @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dress_id", nullable = false)
    @NotNull(message = "Dress is required")
    private Dress dress;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seller_id", nullable = false)
    @NotNull(message = "Seller is required")
    private User seller;

   
}
