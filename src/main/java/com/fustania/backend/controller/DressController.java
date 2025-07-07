package com.fustania.backend.controller;

import com.fustania.backend.dto.DressDTO;
import com.fustania.backend.dto.MessageDTO;
import com.fustania.backend.service.DressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/dresses")
public class DressController {
    @Autowired
    private DressService dressService;

    @GetMapping
    public ResponseEntity<List<DressDTO>> getAllDresses(
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String countryName,
            @RequestParam(required = false) Double maxPrice,
            @RequestParam(required = false) String size,
            @RequestParam(required = false) String color,
            @RequestParam(required = false) String city,
            @RequestParam(required = false) String sellerName) {
        List<DressDTO> dresses = dressService.getAllDresses(category, countryName, maxPrice, size, color, city, sellerName);
        return ResponseEntity.ok(dresses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DressDTO> getDressById(@PathVariable Long id) {
        DressDTO dress = dressService.getDressById(id);
        return ResponseEntity.ok(dress);
    }
    @PostMapping
    public ResponseEntity<String> createDress(@RequestBody DressDTO dressDTO) {
        dressService.createDress(dressDTO);
        return ResponseEntity.ok("Dress created successfully");
    }

    @PostMapping("/{id}/contact")
    public ResponseEntity<String> contactSeller(@PathVariable Long id, @RequestBody MessageDTO messageDTO) {
        messageDTO.setDressId(id);
        dressService.sendMessageAndOffer(messageDTO);
        return ResponseEntity.ok("Message sent successfully");
    }
}
