package com.customer.rewards.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.customer.rewards.domain.Transaction;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Long> {
	public List<Transaction> findAllByCustomerId(Long customerId);

	public List<Transaction> findAllByCustomerIdAndTransactionDateBetween(Long customerId, Timestamp from,
			Timestamp to);
}