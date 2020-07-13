package com.customer.rewards.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customer.rewards.domain.Customer;
import com.customer.rewards.exception.CustomerException;
import com.customer.rewards.model.RewardsResponse;
import com.customer.rewards.service.CustomerService;
import com.customer.rewards.service.RewardsService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/customers")
public class RewardsController {

	@Autowired
	RewardsService rewardsService;

	@Autowired
	CustomerService customerService;

	@GetMapping(value = "/{customerId}/rewardPoints", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "calculate reward points", notes = "provide customer Id to look up reward points for the past three months", response = RewardsResponse.class)
	public ResponseEntity<RewardsResponse> getRewardsByCustomerId(
			@ApiParam(required = true) @PathVariable("customerId") Long customerId) {
		Customer customer = customerService.getCustomerByCustomerId(customerId);
		if (customer == null) {
			throw new CustomerException("Invalid Customer Id ");
		}
		RewardsResponse customerRewards = rewardsService.getRewardPointsByCustomerId(customerId);
		return new ResponseEntity<>(customerRewards, HttpStatus.OK);
	}
}
