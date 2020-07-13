package com.customer.rewards.service;

import com.customer.rewards.domain.Customer;

public interface CustomerService {

	public Customer getCustomerByCustomerId(Long customerId);

}
