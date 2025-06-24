package com.example.fustaniabackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.fustaniabackend.dto.DressDTO;
import com.example.fustaniabackend.service.DressService;

@RestController
@RequestMapping("/api/dresses")
public class DressController {

    @Autowired
    private DressService dressService;

    @GetMapping
    public ResponseEntity<List<DressDTO>>getAllDresses(
        @RequestParam(required = false) Double priceMin,
        @RequestParam(required = false) Double priceMax,
        @RequestParam(required = false) String size,
        @RequestParam(required = false) String color
    ){
        List<DressDTO> dresses = dressService.getAllDresses(priceMin, priceMax, size, color);
        return ResponseEntity.ok(dresses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DressDTO> getDressById(@PathVariable Long id){
        DressDTO dress = dressService.getDressById(id);
        if (dress == null) {
         return ResponseEntity.notFound().build();
            
        }
        return ResponseEntity.ok(dress);
    }

  

}
