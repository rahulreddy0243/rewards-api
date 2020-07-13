package com.customer.rewards.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.customer.rewards.domain.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
	public Customer findByCustomerId(Long customerId);
}