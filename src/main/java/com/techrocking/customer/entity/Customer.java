package com.techrocking.customer.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
@Table(name = "customer")
public class Customer implements Serializable {
	
	private static final long serialVersionUID = 7501236854841404284L;
	
	@NotNull
	@Column(name = "name")
	private String name;
	
	@NotNull
	@Id
	@Column(name = "id")
	private Long id;
	
	@NotNull
	@Column(name = "password")
	private String password;
	
	@NotNull
	@Column(name = "phone")
	private String phone;

}
