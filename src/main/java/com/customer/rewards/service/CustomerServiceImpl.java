package com.customer.rewards.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.rewards.domain.Customer;
import com.customer.rewards.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	@Override
	public Customer getCustomerByCustomerId(Long customerId) {
		return customerRepository.findByCustomerId(customerId);
	}
}
