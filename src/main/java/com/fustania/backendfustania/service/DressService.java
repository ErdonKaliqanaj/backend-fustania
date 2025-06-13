package com.fustania.backendfustania.service;

import java.util.List;
import com.fustania.backendfustania.model.Dress;
import com.fustania.backendfustania.repository.DressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DressService {

	@Autowired
	private DressRepository dressRepository;
	
	public List<Dress> getDresses(String dizajneri, String masa, Double maxCmimi, String ngjyra, String shteti, String qyteti){
		return dressRepository.findByFilters(dizajneri, masa, maxCmimi, ngjyra, shteti, qyteti);
	}
}
