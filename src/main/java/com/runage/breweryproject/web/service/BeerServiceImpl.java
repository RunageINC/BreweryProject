package com.runage.breweryproject.web.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.runage.breweryproject.web.dto.BeerDTO;

@Service
public class BeerServiceImpl implements BeerService {

	@Override
	public BeerDTO getBeerById(UUID beerId) {
		return BeerDTO.builder().id(UUID.randomUUID())
				.beerName("Test")
				.beerStyle("Test")
				.build();
	}
	
	@Override
	public BeerDTO saveNewBeer(BeerDTO beerDTO) {
		return BeerDTO.builder().id(UUID.randomUUID())
				.beerName("SavedTest")
				.beerStyle("SavedTest")
				.build();
	}
	
	@Override
	public void updateBeer(UUID id, BeerDTO beerDTO) {
		
	}
	
	@Override
	public void deleteBeer(UUID id) {}
}
