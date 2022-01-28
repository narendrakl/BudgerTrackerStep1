package com.cts.budgettracker.service;

import java.util.List;

import com.cts.budgettracker.entities.AccountHolder;
import com.cts.budgettracker.exception.ProfileException;

public interface AccountHolderService {

	 List<AccountHolder> getAllAccountHolders() throws ProfileException;
	 AccountHolder getById(long id) throws ProfileException;
	 AccountHolder add(AccountHolder accountHolder) throws ProfileException;
	 AccountHolder update(AccountHolder accountHolder) throws ProfileException; 
	 boolean existsByAccountHolderId(Long id) throws ProfileException;
}
