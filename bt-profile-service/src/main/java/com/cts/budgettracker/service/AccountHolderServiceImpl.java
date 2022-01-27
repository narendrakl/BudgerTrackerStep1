package com.cts.budgettracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.budgettracker.entities.AccountHolder;
import com.cts.budgettracker.exception.ProfileException;
import com.cts.budgettracker.repo.AccountHolderRepo;

@Service
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
		if(achRepo.existsByEmailId(accountHolder.getEmailId())) {
			throw new ProfileException("An account holder with emailid is already exists");
		}
		if(achRepo.existsByMobileNumber(accountHolder.getMobileNumber())) {
			throw new ProfileException("An account holder with mobilenumber is already exists");
		}
		return achRepo.save(accountHolder);
	}

	@Override
	public AccountHolder update(AccountHolder accountHolder) throws ProfileException {
		// TODO Auto-generated method stub
		AccountHolder oldAccountHolder = achRepo.findById(accountHolder.getAhId()).orElse(null);
		if(oldAccountHolder == null) {
			throw new ProfileException("Account holder with id does not exist");
		}
		if(oldAccountHolder.getEmailId().equals(accountHolder.getEmailId()) && achRepo.existsByEmailId(accountHolder.getEmailId())){
			throw new ProfileException("Account holder with email already exist"); 
		}
		if(oldAccountHolder.getMobileNumber().equals(accountHolder.getMobileNumber()) && achRepo.existsByMobileNumber(accountHolder.getMobileNumber())){
			throw new ProfileException("Account holder with id already exist"); 
		}
		return achRepo.save(accountHolder);
	}

}
