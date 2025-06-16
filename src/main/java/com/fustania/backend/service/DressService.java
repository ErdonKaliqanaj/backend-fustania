package com.fustania.backend.service;

import java.util.Optional;

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
}
