package com.fustania.backend.controller;

import com.fustania.backend.dto.DressDetailsDto;
import com.fustania.backend.model.BuyUser;
import com.fustania.backend.model.Dress;
import com.fustania.backend.service.DressService;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/dresses")
public class DressController {

    private final DressService dressService;

    public DressController(DressService dressService) {
        this.dressService = dressService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<DressDetailsDto> getDressById(@PathVariable Long id) {
        return dressService.getDressById(id)
                .map(dress -> {
                    BuyUser seller = dress.getSeller();
                    DressDetailsDto dto = new DressDetailsDto();
                    dto.setDescription(dress.getDescription());
                    dto.setPrice(dress.getPrice());
                    dto.setSize(dress.getSize());
                    dto.setPhotoUrl(dress.getPhotoUrl());
                    dto.setSellerFirstName(seller.getFirstName());
                    dto.setSellerLastName(seller.getLastName());
                    dto.setSellerEmail(seller.getEmail());
                    dto.setSellerAddress(seller.getAddress());
                    dto.setSellerId(seller.getId());
                    return ResponseEntity.ok(dto);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    @GetMapping
    public List<DressDetailsDto> getAllDresses(
            @RequestParam(required = false) String designer,
            @RequestParam(required = false) String size,
            @RequestParam(required = false) Double maxPrice,
            @RequestParam(required = false) String color,
            @RequestParam(required = false) String shteti,
            @RequestParam(required = false) String qyteti) {
        List<Dress> dresses = dressService.getFilteredDresses(designer, size, maxPrice, color, shteti, qyteti);
        return dresses.stream().map(dress -> {
            BuyUser seller = dress.getSeller();
            DressDetailsDto dto = new DressDetailsDto();
            dto.setDescription(dress.getDescription());
            dto.setPrice(dress.getPrice());
            dto.setSize(dress.getSize());
            dto.setPhotoUrl(dress.getPhotoUrl());
            dto.setSellerFirstName(seller.getFirstName());
            dto.setSellerLastName(seller.getLastName());
            dto.setSellerEmail(seller.getEmail());
            dto.setSellerAddress(seller.getAddress());
            return dto;
        }).collect(Collectors.toList());
    }
}

