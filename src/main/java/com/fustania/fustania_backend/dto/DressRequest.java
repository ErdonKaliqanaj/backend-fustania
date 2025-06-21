package com.fustania.fustania_backend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class DressRequest {
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
    @NotBlank(message = "City is required")
    private String qyteti;
    @NotBlank(message = "Country is required")
    private String shteti;
    
}
