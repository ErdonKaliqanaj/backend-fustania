package com.fustania.backend.controller;

import com.fustania.backend.dto.DressDetailsDto;
import com.fustania.backend.model.BuyUser;
import com.fustania.backend.model.Dress;
import com.fustania.backend.service.DressService;
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
                    return ResponseEntity.ok(dto);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}

