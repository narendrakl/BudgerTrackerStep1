package com.cts.budgettracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cts.budgettracker.entities.AccountHolder;
import com.cts.budgettracker.exception.ProfileException;
import com.cts.budgettracker.repo.AccountHolderRepo;

public class AccountHolderServiceImpl implements AccountHolderService {

	@Autowired
	AccountHolderRepo achRepo;
	
	@Override
	public List<AccountHolder> getAllAccountHolders() throws ProfileException {
		// TODO Auto-generated method stub
		return achRepo.findAll();
	}

	@Override
	public AccountHolder getById(long id) throws ProfileException {
		// TODO Auto-generated method stub
		return achRepo.findById(id).get();
	}

	@Override
	public AccountHolder add(AccountHolder accountHolder) throws ProfileException {
		// TODO Auto-generated method stub
		if(accountHolder.getAhId() != null && achRepo.existsById(accountHolder.getAhId())) {
			throw new ProfileException("An account holder with id is already exists");
		}
		if(accountHolder.getAhId() != null && achRepo.existsByEmailId(accountHolder.getEmailId())) {
			throw new ProfileException("An account holder with emailid is already exists");
		}
		if(accountHolder.getAhId() != null && achRepo.existsByMobileNumber(accountHolder.getMobileNumber())) {
			throw new ProfileException("An account holder with mobilenumber is already exists");
		}
		return achRepo.save(accountHolder);
	}

	@Override
	public AccountHolder update(AccountHolder accountHolder) throws ProfileException {
		// TODO Auto-generated method stub
		if(accountHolder.getAhId() != null && !achRepo.existsById(accountHolder.getAhId())) {
			throw new ProfileException("An account holder with id is does not exists");
		}
		return achRepo.save(accountHolder);
	}

}
