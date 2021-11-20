package com.runage.breweryproject.web.service;

import java.util.UUID;

import com.runage.breweryproject.web.dto.BeerDTO;

public interface BeerService {

	BeerDTO getBeerById(UUID beerId);
	BeerDTO saveNewBeer(BeerDTO beerDTO);
	void updateBeer(UUID beerId, BeerDTO beerDTO);
	void deleteBeer(UUID beerId);
}
