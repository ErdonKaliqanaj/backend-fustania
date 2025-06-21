package com.fustania.fustania_backend.dto;

import lombok.Data;

import java.util.List;



@Data
public class DressResponse {
    private Long id;
    private String description;
    private Double price;
    private String size;
    private String designer;
    private String color;
    private String shteti;
    private String qyteti;
    private List<String> photos;
    private Long sellerId;
    private String sellerName;
    private String sellerEmail;
   

   
}