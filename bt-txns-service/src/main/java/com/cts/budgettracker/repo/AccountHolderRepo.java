package com.cts.budgettracker.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.budgettracker.entities.AccountHolder;

@Repository
public interface AccountHolderRepo extends JpaRepository<AccountHolder, Long> {

}
