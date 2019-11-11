package com.techrocking.customer.payload;

import lombok.Data;

@Data
public class CustomerRequestPayload {
	
	private String name;
	private String password;
	private String phone;
	private Long id;

}
