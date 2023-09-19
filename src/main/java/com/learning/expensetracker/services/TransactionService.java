package com.learning.expensetracker.services;

import java.util.List;

import com.learning.expensetracker.domain.Transaction;
import com.learning.expensetracker.exceptions.EtBadRequestException;
import com.learning.expensetracker.exceptions.EtResourceNotFoundException;

public interface TransactionService {

	List<Transaction> fetchAllTransactions(Integer userid, Integer categoryId);

	Transaction fetchTransactionById(Integer userId, Integer categoryId, Integer transactionId)
			throws EtResourceNotFoundException;

	Transaction addTransaction(Integer userId, Integer categoryId, Double amount, String note, Long transactionDate)
			throws EtBadRequestException;

	void updateTransaction(Integer userId, Integer categoryId, Integer transactionId, Transaction transaction)
			throws EtBadRequestException;
	
	void removeTransaction(Integer userId, Integer categoryId, Integer transactionId)throws
	        EtResourceNotFoundException;

}
