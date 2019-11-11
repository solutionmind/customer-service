package com.techrocking.customer.payload;

import lombok.Data;

@Data
public class CustomerResponsePayload {

	private String name;
	private String password;
	private String phone;
	private Long id;
	private String message;
}
