package com.runage.breweryproject.web.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.runage.breweryproject.web.dto.CustomerDTO;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Override
	public CustomerDTO getCustomerById(UUID customerId) {
		return CustomerDTO.builder().id(UUID.randomUUID())
				.name("Random test name").build();
	}

	@Override
	public CustomerDTO saveNewCustomer(CustomerDTO customerDTO) {
		return CustomerDTO.builder().id(UUID.randomUUID())
				.name("Random test name").build();
	}
	
	@Override
	public void updateCustomer(UUID id, CustomerDTO customerDTO) {}
	
	@Override
	public void deleteCustomer(UUID id) {}
}
