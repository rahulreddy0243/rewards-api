package com.customer.rewards.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RewardsResponse {

	@JsonProperty("customerId")
	private long customerId;
	@JsonProperty("lastMonthRewardPoints")
	private long lastMonthRewardPoints;
	@JsonProperty("lastSecondMonthRewardPoints")
	private long lastSecondMonthRewardPoints;
	@JsonProperty("lastThirdMonthRewardPoints")
	private long lastThirdMonthRewardPoints;
	@JsonProperty("totalRewardPoints")
	private long totalRewardPoints;

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public long getLastMonthRewardPoints() {
		return lastMonthRewardPoints;
	}

	public void setLastMonthRewardPoints(long lastMonthRewardPoints) {
		this.lastMonthRewardPoints = lastMonthRewardPoints;
	}

	public long getLastSecondMonthRewardPoints() {
		return lastSecondMonthRewardPoints;
	}

	public void setLastSecondMonthRewardPoints(long lastSecondMonthRewardPoints) {
		this.lastSecondMonthRewardPoints = lastSecondMonthRewardPoints;
	}

	public long getLastThirdMonthRewardPoints() {
		return lastThirdMonthRewardPoints;
	}

	public void setLastThirdMonthRewardPoints(long lastThirdMonthRewardPoints) {
		this.lastThirdMonthRewardPoints = lastThirdMonthRewardPoints;
	}

	public long getTotalRewardPoints() {
		return totalRewardPoints;
	}

	public void setTotalRewardPoints(long totalRewardPoints) {
		this.totalRewardPoints = totalRewardPoints;
	}

}
