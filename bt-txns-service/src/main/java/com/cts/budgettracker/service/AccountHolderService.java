package com.cts.budgettracker.service;

import com.cts.budgettracker.entities.AccountHolder;

public interface AccountHolderService {

	AccountHolder getById(Long Id);
	void save(AccountHolder accountHolder);
}
