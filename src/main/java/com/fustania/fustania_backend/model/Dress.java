package com.fustania.fustania_backend.model;

import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Entity
@Table(name="dresses")
@Data
public class Dress {
 @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Description is required")
    private String description;

    @Positive(message = "Price must be positive")
    @NotNull(message = "Price is required")
    private Double price;

    @NotBlank(message = "Size is required")
    private String size;

    @NotBlank(message = "Designer is required")
    private String designer;

     @NotBlank(message = "Color is required")
     private String color;

     @Enumerated(EnumType.STRING)
     @NotNull(message = "Country is required")
     private String shteti;

     @NotBlank(message = "City is required")
     private String qyteti;

    @NotEmpty(message = "At least one photo is required")
    @ElementCollection
    @CollectionTable(name = "dress_photos", joinColumns = @JoinColumn(name = "dress_id"))
    @Column(name = "photo_url")
    private List<String> photos;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seller_id", nullable = false)
    @NotNull(message = "Seller is required")
    private User seller;
}
