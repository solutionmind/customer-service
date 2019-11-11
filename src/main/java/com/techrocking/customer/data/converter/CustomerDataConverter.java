package com.techrocking.customer.data.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.techrocking.customer.entity.Customer;
import com.techrocking.customer.payload.CustomerResponsePayload;

@Component
public class CustomerDataConverter {

	public CustomerResponsePayload convert(Customer entity) {
		CustomerResponsePayload payload = new CustomerResponsePayload();
		payload.setId(entity.getId());
		payload.setName(entity.getName());
		payload.setPassword(entity.getPassword());
		payload.setPhone(entity.getPhone());
		return payload;
	}

	public List<CustomerResponsePayload> convert(List<Customer> entityList) {
		List<CustomerResponsePayload> payloadList = new ArrayList<CustomerResponsePayload>();
		for (Customer customer : entityList) {
			CustomerResponsePayload payload = new CustomerResponsePayload();
			payload.setId(customer.getId());
			payload.setName(customer.getName());
			payload.setPassword(customer.getPassword());
			payload.setPhone(customer.getPhone());
			payloadList.add(payload);
		}
		return payloadList;
	}

}
