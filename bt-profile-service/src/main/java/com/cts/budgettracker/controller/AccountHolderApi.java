package com.cts.budgettracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.budgettracker.entities.AccountHolder;
import com.cts.budgettracker.exception.ProfileException;
import com.cts.budgettracker.service.AccountHolderService;

@RestController
@RequestMapping("/profiles")
public class AccountHolderApi {
	
	@Autowired
	private AccountHolderService achService;

	@PostMapping("/add")
	public ResponseEntity<AccountHolder> add(@RequestBody AccountHolder accountHolder) throws ProfileException{
		return ResponseEntity.ok(achService.add(accountHolder));		
	}
	
	@PutMapping
	public ResponseEntity<AccountHolder> updateAccountHolder(@RequestBody AccountHolder accountHolder) throws ProfileException{
		AccountHolder ach = achService.update(accountHolder);
		return new ResponseEntity(ach, HttpStatus.ACCEPTED);
	}
	
	@GetMapping
	public ResponseEntity<List<AccountHolder>> getAllAccountHolders() throws ProfileException{
		return ResponseEntity.ok(achService.getAllAccountHolders());
	}
	
	@GetMapping("/{ahId}")
	public ResponseEntity<AccountHolder> getAccountHolderById(@PathVariable Long ahId) throws ProfileException{
		AccountHolder ach = achService.getById(ahId);
		return ach == null? ResponseEntity.notFound().build() : ResponseEntity.ok(ach);
	}
	
	@GetMapping("/{ahId}/exists")
	public ResponseEntity<Boolean> existsByAccountHolderId(@PathVariable("ahId") Long ahId) throws ProfileException{
		return ResponseEntity.ok(achService.existsByAccountHolderId(ahId));
	}
}
