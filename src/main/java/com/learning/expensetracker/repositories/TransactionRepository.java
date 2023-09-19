package com.learning.expensetracker.repositories;

import java.util.List;

import com.learning.expensetracker.domain.Transaction;
import com.learning.expensetracker.exceptions.EtBadRequestException;
import com.learning.expensetracker.exceptions.EtResourceNotFoundException;

public interface TransactionRepository {

	List<Transaction> findAll(Integer userid, Integer categoryId);

	Transaction findById(Integer userId, Integer categoryId, Integer transactionId) throws EtResourceNotFoundException;

	Integer create(Integer userId, Integer categoryId, Double amount, String note, Long transactionDate)
			throws EtBadRequestException;

	void update(Integer userId, Integer categoryId, Integer transactionId, Transaction transaction)
			throws EtBadRequestException;

	void removeById(Integer userId, Integer categoryId, Integer transactionId)
			throws EtResourceNotFoundException;
}
