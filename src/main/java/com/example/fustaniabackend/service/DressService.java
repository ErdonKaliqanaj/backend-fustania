package com.example.fustaniabackend.service;

import com.example.fustaniabackend.dto.DressDTO;
import com.example.fustaniabackend.entity.Dress;
import com.example.fustaniabackend.repository.DressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import java.util.stream.Collectors;

@Service
public class DressService {
    @Autowired
    private DressRepository dressRepository;

    public List<DressDTO> getDressesBySeller(Long sellerId){
        return dressRepository.findBySellerId(sellerId).stream().map(this::mapToDTO).collect(Collectors.toList());
    }

   

    public List<DressDTO> getAllDresses(Double priceMin, Double priceMax, String size, String color) {
        return dressRepository.findByFilters(priceMin, priceMax, size, color).stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public DressDTO getDressById(Long id){
        return dressRepository.findById(id).map(this::mapToDTO).orElse(null);
    }

    private DressDTO mapToDTO(Dress dress) {
        DressDTO dto = new DressDTO();
        dto.setId(dress.getId());
        dto.setName(dress.getName());
        dto.setPrice(dress.getPrice());
        dto.setSize(dress.getSize());
        dto.setColor(dress.getColor());
        dto.setDesigner(dress.getDesigner());
        dto.setDescription(dress.getDescription());
        dto.setImgUrl(dress.getImageUrl());
        dto.setSellerId(dress.getSeller().getId());
        return dto;
    }
}