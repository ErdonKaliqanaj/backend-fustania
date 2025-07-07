package com.fustania.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DressDTO {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private String category;
    private String size;
    private String color;
    private String city;
    private String photoUrl;
    private String countryName;
    private Long sellerId;
    private String sellerName;
    private String sellerEmail;
    private String sellerAddress;
}
