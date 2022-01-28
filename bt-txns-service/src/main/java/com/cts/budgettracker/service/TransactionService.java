package com.cts.budgettracker.service;

import java.time.LocalDate;
import java.util.List;

import com.cts.budgettracker.entities.Transaction;
import com.cts.budgettracker.exception.TransactionException;

public interface TransactionService {

	List<Transaction> getAllTransactionForAccountHolder(Long ahId) throws TransactionException;
	
	Transaction addTransaction(Transaction transaction) throws TransactionException;
	
	Transaction updateTransaction(Transaction transaction) throws TransactionException;
	
	Transaction getTransactionById(Long txnsId) throws TransactionException;
	
	List<Transaction> getTransactionsBetweenDates(Long ahId, LocalDate start, LocalDate end) throws TransactionException;
	
	void deleteTransactionById(Long txnsId) throws TransactionException;
}
