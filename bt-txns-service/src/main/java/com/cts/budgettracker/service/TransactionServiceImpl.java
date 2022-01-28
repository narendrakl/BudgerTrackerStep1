package com.cts.budgettracker.service;

import java.time.LocalDate;
import java.util.List;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.budgettracker.entities.AccountHolder;
import com.cts.budgettracker.entities.Transaction;
import com.cts.budgettracker.entities.TransactionType;
import com.cts.budgettracker.exception.TransactionException;
import com.cts.budgettracker.repo.AccountHolderRepo;
import com.cts.budgettracker.repo.TransactionRepo;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	TransactionRepo txnsRepo;

	@Autowired
	AccountHolderService achService; 
	
	@Autowired
	ProfileServiceClient profileService;

	@Override
	public List<Transaction> getAllTransactionForAccountHolder(Long ahId) {
		return txnsRepo.findAllByAccountHolderId(ahId);
	}
	
	@Override
	public Transaction addTransaction(Transaction transaction) throws TransactionException {
		long ahId = transaction.getHolder().getAhId();
		
		AccountHolder ach = achService.getById(ahId);
		
		if(ach == null) {
			if(!profileService.existsByAccountHolderId(ahId)) {
				throw new TransactionException("Account holder does not exist");
			}
			ach = new AccountHolder(ahId, 0.0, new TreeSet<>());
		}
		
		transaction.setHolder(ach);
		ach.setCurrentBalance(transaction.getTxnType()==TransactionType.CREDIT?
				ach.getCurrentBalance()+transaction.getAmount():
					ach.getCurrentBalance()-transaction.getAmount());
		
		achService.save(ach);
		transaction = txnsRepo.save(transaction);
		
		return transaction;
	}

	@Override
	public Transaction updateTransaction(Transaction transaction) {
		long ahId = transaction.getHolder().getAhId();
		
		AccountHolder ach = achService.getById(ahId);		
		transaction.setHolder(ach);
		ach.setCurrentBalance(transaction.getTxnType()==TransactionType.CREDIT?
				ach.getCurrentBalance()+transaction.getAmount():
					ach.getCurrentBalance()-transaction.getAmount());
		
		achService.save(ach);
		transaction = txnsRepo.save(transaction);
		
		return transaction;
	}

	@Override
	public Transaction getTransactionById(Long txnsId) {
		return txnsRepo.findById(txnsId).orElse(null);
	}

	@Override
	public List<Transaction> getTransactionsBetweenDates(Long ahId, LocalDate start, LocalDate end) {
		return txnsRepo.findAllByAccountHolderIdOfPeriod(ahId, start, end);
	}

	@Override
	public void deleteTransactionById(Long txnsId) {
		 txnsRepo.deleteById(txnsId);
	}

}
