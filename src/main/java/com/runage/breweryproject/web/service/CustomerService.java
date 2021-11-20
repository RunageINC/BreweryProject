package com.runage.breweryproject.web.service;

import java.util.UUID;

import com.runage.breweryproject.web.dto.CustomerDTO;

public interface CustomerService {

	CustomerDTO getCustomerById(UUID customerId);
	CustomerDTO saveNewCustomer(CustomerDTO customerDTO);
	void updateCustomer(UUID customerId, CustomerDTO customerDTO);
	void deleteCustomer(UUID customerId);
}
