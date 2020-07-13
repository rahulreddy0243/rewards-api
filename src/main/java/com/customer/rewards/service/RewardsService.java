package com.customer.rewards.service;

import com.customer.rewards.model.RewardsResponse;

public interface RewardsService {

	public RewardsResponse getRewardPointsByCustomerId(Long customerId);

}
