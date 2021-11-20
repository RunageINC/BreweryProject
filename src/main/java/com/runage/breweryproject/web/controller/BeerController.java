package com.runage.breweryproject.web.controller;

import java.util.UUID;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.runage.breweryproject.web.dto.BeerDTO;
import com.runage.breweryproject.web.service.BeerService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/beer")
@AllArgsConstructor
@SuppressWarnings("rawtypes")
public class BeerController {

	private final BeerService beerService;
	
	@GetMapping("/{beerId}")
	public ResponseEntity<BeerDTO> getBeer(@PathVariable UUID beerId) {
		return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);
	}
	
	@SuppressWarnings("unchecked")
	@PostMapping
	public ResponseEntity saveBeer(@RequestBody BeerDTO beerDTO) {
		BeerDTO savedDTO = beerService.saveNewBeer(beerDTO);
		HttpHeaders headers = new HttpHeaders();
		
		headers.add("Location", String.format("/api/v1/beer/%s", savedDTO.getId().toString()));
		
		return new ResponseEntity(headers, HttpStatus.CREATED);
	}
	
	@PutMapping("/{beerId}")
	public ResponseEntity updateBeer(@PathVariable("beerId") UUID beerId, @RequestBody BeerDTO beerDTO) {
		beerService.updateBeer(beerId, beerDTO);
		
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping("{/beerId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteBeer(@PathVariable UUID beerId) {
		beerService.deleteBeer(beerId);
	}
}
