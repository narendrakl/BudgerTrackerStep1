package com.cts.budgettracker.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.budgettracker.entities.AccountHolder;

public interface AccountHolderRepo extends JpaRepository<AccountHolder, Long> {
	
	boolean existsByEmailId(String emailId);
	boolean existsByMobileNumber(String mobileNumber);

}
