package com.fustania.backend.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fustania.backend.model.Dress;
import com.fustania.backend.repository.DressRepository;

@Service
public class DressService {
private final DressRepository dressRepository;

public DressService(DressRepository dressRepository) {
	this.dressRepository = dressRepository;
}
@Transactional(readOnly = true)
public Optional<Dress> getDressById(Long id){
	return dressRepository.findById(id);
}

@Transactional(readOnly = true)
public List<Dress> getFilteredDresses(
        String designer, String size, Double maxPrice, String color, String shteti, String qyteti) {
	List<Dress> dresses = dressRepository.findAll();
	if (designer != null && !designer.isEmpty()) {
        dresses = dresses.stream()
                .filter(dress -> dress.getDescription().toLowerCase().contains(designer.toLowerCase()))
                .collect(Collectors.toList());
    }

    if (size != null && !size.isEmpty()) {
        dresses = dresses.stream()
                .filter(dress -> dress.getSize().equalsIgnoreCase(size))
                .collect(Collectors.toList());
    }

    if (maxPrice != null) {
        dresses = dresses.stream()
                .filter(dress -> dress.getPrice() <= maxPrice)
                .collect(Collectors.toList());
    }

    if (color != null && !color.isEmpty()) {
        dresses = dresses.stream()
                .filter(dress -> dress.getDescription().toLowerCase().contains(color.toLowerCase()))
                .collect(Collectors.toList());
    }

    if (shteti != null && !shteti.isEmpty()) {
        dresses = dresses.stream()
                .filter(dress -> dress.getSeller().getShteti().name().equalsIgnoreCase(shteti))
                .collect(Collectors.toList());
    }

    if (qyteti != null && !qyteti.isEmpty()) {
        dresses = dresses.stream()
                .filter(dress -> dress.getSeller().getAddress().toLowerCase().contains(qyteti.toLowerCase()))
                .collect(Collectors.toList());
    }

    return dresses;
}
}

