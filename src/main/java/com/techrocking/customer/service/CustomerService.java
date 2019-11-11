package com.techrocking.customer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techrocking.customer.entity.Customer;
import com.techrocking.customer.payload.CustomerRequestPayload;
import com.techrocking.customer.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository repository;
	

	public Customer saveCustomer(CustomerRequestPayload request) {
		Customer customerEntity = new Customer();
		customerEntity.setName(request.getName());
		customerEntity.setPassword(request.getPassword());
		customerEntity.setPhone(request.getPhone());
		
		if(request.getId() == null) {//new entity
			Long id = getNextId(repository.getMaxId());
			customerEntity.setId(id);
		}
		return repository.save(customerEntity);
	}

	public void deleteCustomer(CustomerRequestPayload request) {
		Customer customerEntity = new Customer();
		customerEntity.setId(request.getId());
		repository.delete(customerEntity);
	}

	public Customer getCustomer(Long id) {
		return repository.getOne(id);

	}

	public List<Customer> getCustomer() {
		return repository.findAll();
	}
	
	private synchronized Long getNextId(Long currentId) {
		if(currentId == null) {
			return Long.valueOf(0);
		}
		return currentId + 1;
		
	}

}
