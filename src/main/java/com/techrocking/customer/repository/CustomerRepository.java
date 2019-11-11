package com.techrocking.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.techrocking.customer.entity.Customer;

@Repository
public interface CustomerRepository  extends JpaRepository<Customer, Long> {
	
	@Query("SELECT MAX(x.id) FROM Customer x")
	public Long getMaxId();

}
