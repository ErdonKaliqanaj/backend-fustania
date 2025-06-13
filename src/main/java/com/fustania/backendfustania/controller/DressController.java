package com.fustania.backendfustania.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fustania.backendfustania.model.Dress;
import com.fustania.backendfustania.repository.DressRepository;
import com.fustania.backendfustania.service.DressService;

@RestController
@RequestMapping("/api/dresses")
public class DressController {
	
	@Autowired
	private DressRepository dressRepository;
	
	@GetMapping("/id")
	public Dress getDressById(@PathVariable Long id) {
		return dressRepository.findById(id).orElse(null);
	}
}
