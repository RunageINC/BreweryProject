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

import com.runage.breweryproject.web.dto.CustomerDTO;
import com.runage.breweryproject.web.service.CustomerService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/customer")
@AllArgsConstructor
@SuppressWarnings("rawtypes")
public class CustomerController {

	private final CustomerService customerService;
	
	@GetMapping({"/customerId"})
	public ResponseEntity<CustomerDTO> getCustomer(@PathVariable UUID customerId) {
		return new ResponseEntity<>(customerService.getCustomerById(customerId), HttpStatus.OK);
	}
	
	@SuppressWarnings("unchecked")
	@PostMapping
	public ResponseEntity saveCustomer(@RequestBody CustomerDTO customerDTO) {
		CustomerDTO savedDTO = customerService.saveNewCustomer(customerDTO);
		HttpHeaders headers = new HttpHeaders();
		
		headers.add("Location", String.format("/api/v1/customer/%s", savedDTO.getId().toString()));
		
		return new ResponseEntity(headers, HttpStatus.CREATED);
	}
	
	@PutMapping("/{customerId}")
	public ResponseEntity updateCustomer(@PathVariable("customerId") UUID customerId, CustomerDTO customerDTO) {
		customerService.updateCustomer(customerId, customerDTO);
		
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping("/{customerId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteCustomer(@PathVariable UUID customerId) {
		customerService.deleteCustomer(customerId);
	}
}
