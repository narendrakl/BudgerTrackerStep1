package com.cts.budgettracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.budgettracker.entities.AccountHolder;
import com.cts.budgettracker.repo.AccountHolderRepo;

@Service
public class AccountHolderServiceImpl implements AccountHolderService {

	@Autowired
	private AccountHolderRepo ahRepo;
	
	@Override
	public AccountHolder getById(Long Id) {
		return ahRepo.findById(Id).orElse(null);
	}
	@Override
	public void save(AccountHolder accountHolder) {
		ahRepo.save(accountHolder);
	}

}
