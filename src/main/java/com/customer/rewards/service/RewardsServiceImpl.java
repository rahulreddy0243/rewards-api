package com.customer.rewards.service;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.rewards.domain.Transaction;
import com.customer.rewards.model.RewardsResponse;
import com.customer.rewards.repository.TransactionRepository;

@Service
public class RewardsServiceImpl implements RewardsService {

	@Autowired
	TransactionRepository transactionRepository;

	public static final int NO_OF_MONTHS = 1;
	public static final int MIN_REWARD_POINTS_AMOUNT = 50;
	public static final int MAX_REWARD_POINTS_AMOUNT = 100;

	@Override
	public RewardsResponse getRewardPointsByCustomerId(Long customerId) {

		Timestamp lastMonthTimestamp = getDateBasedOnOffSetMonths(NO_OF_MONTHS);
		Timestamp lastSecondMonthTimestamp = getDateBasedOnOffSetMonths(2 * NO_OF_MONTHS);
		Timestamp lastThirdMonthTimestamp = getDateBasedOnOffSetMonths(3 * NO_OF_MONTHS);

		List<Transaction> lastMonthTransactions = transactionRepository.findAllByCustomerIdAndTransactionDateBetween(
				customerId, lastMonthTimestamp, Timestamp.from(Instant.now()));
		List<Transaction> lastSecondMonthTransactions = transactionRepository
				.findAllByCustomerIdAndTransactionDateBetween(customerId, lastSecondMonthTimestamp, lastMonthTimestamp);
		List<Transaction> lastThirdMonthTransactions = transactionRepository
				.findAllByCustomerIdAndTransactionDateBetween(customerId, lastThirdMonthTimestamp,
						lastSecondMonthTimestamp);

		Long lastMonthRewardPoints = getRewardPointsPerMonth(lastMonthTransactions);
		Long lastSecondMonthRewardPoints = getRewardPointsPerMonth(lastSecondMonthTransactions);
		Long lastThirdMonthRewardPoints = getRewardPointsPerMonth(lastThirdMonthTransactions);

		RewardsResponse customerRewards = new RewardsResponse();
		customerRewards.setCustomerId(customerId);
		customerRewards.setLastMonthRewardPoints(lastMonthRewardPoints);
		customerRewards.setLastSecondMonthRewardPoints(lastSecondMonthRewardPoints);
		customerRewards.setLastThirdMonthRewardPoints(lastThirdMonthRewardPoints);
		customerRewards
				.setTotalRewardPoints(lastMonthRewardPoints + lastSecondMonthRewardPoints + lastThirdMonthRewardPoints);

		return customerRewards;

	}

	private Long getRewardPointsPerMonth(List<Transaction> transactions) {
		return transactions.stream().map(transaction -> calculateRewardPoints(transaction))
				.collect(Collectors.summingLong(r -> r.longValue()));
	}

	private Long calculateRewardPoints(Transaction t) {
		if (t.getTransactionAmount() > MIN_REWARD_POINTS_AMOUNT
				&& t.getTransactionAmount() <= MAX_REWARD_POINTS_AMOUNT) {
			return Math.round(t.getTransactionAmount() - MIN_REWARD_POINTS_AMOUNT);
		} else if (t.getTransactionAmount() > MAX_REWARD_POINTS_AMOUNT) {
			return Math.round(t.getTransactionAmount() - MAX_REWARD_POINTS_AMOUNT) * 2
					+ (MAX_REWARD_POINTS_AMOUNT - MIN_REWARD_POINTS_AMOUNT);
		} else
			return 0l;

	}

	private Timestamp getDateBasedOnOffSetMonths(int months) {
		return Timestamp.valueOf(LocalDateTime.now().minusMonths(months));
	}

}
