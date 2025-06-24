package com.example.fustaniabackend.dto;



import lombok.Data;

@Data
public class DressDTO {

   private Long id;
    private String name;
    private Double price;
    private String designer;
    private String imgUrl;
    private String description;
    private String color;
    private String size;
    private Long sellerId;
}
