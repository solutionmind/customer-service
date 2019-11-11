package com.techrocking.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.techrocking.customer.data.converter.CustomerDataConverter;
import com.techrocking.customer.entity.Customer;
import com.techrocking.customer.payload.CustomerRequestPayload;
import com.techrocking.customer.payload.CustomerResponsePayload;
import com.techrocking.customer.service.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService service;
	
	@Autowired
	private CustomerDataConverter converter;
	
	@GetMapping
	public List<CustomerResponsePayload> getCustomer() {
		List<Customer> customerEntity =  service.getCustomer();
		return converter.convert(customerEntity);
	}
	
	@GetMapping("{id}")
	public CustomerResponsePayload getCustomer(@PathVariable(value = "id") Long customerId) {
		Customer customerEntity =  service.getCustomer(customerId);
		return converter.convert(customerEntity);
	}
	
	@PostMapping()
	public CustomerResponsePayload saveCustomer(@RequestBody CustomerRequestPayload payload) {
		Customer customerEntity =  service.saveCustomer(payload);
		return converter.convert(customerEntity);
	}
	
	@GetMapping("ping")
	public String ping() {
		return "Service is up and running";
	}
	
	

}
