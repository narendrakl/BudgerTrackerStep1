package com.cts.budgettracker.controller;

import java.time.LocalDate;
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

import com.cts.budgettracker.entities.Transaction;
import com.cts.budgettracker.exception.TransactionException;
import com.cts.budgettracker.service.TransactionService;

@RestController
@RequestMapping("/transaction")
public class TransactionApi {
	
	@Autowired
	private TransactionService txnService;

	@GetMapping("/accountHolder/{ahId}")
	public ResponseEntity<List<Transaction>> getTransactionsForAccountHolder(@PathVariable("ahId") Long ahId) throws TransactionException{
		return ResponseEntity.ok(txnService.getAllTransactionForAccountHolder(ahId));
		
	}
	
	@PostMapping("/add")
	public ResponseEntity<Transaction> addTransaction(@RequestBody Transaction txn) throws TransactionException{
		return new ResponseEntity<Transaction>(txnService.addTransaction(txn), HttpStatus.CREATED);
		
	}
	
	@PutMapping
	public ResponseEntity<Transaction> updateTransaction(@RequestBody Transaction txn) throws TransactionException{
		return new ResponseEntity<Transaction>(txnService.updateTransaction(txn), HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/accountHolder/{ahId}/{start}/{end}")
	public ResponseEntity<List<Transaction>> getTransactionsForAccountHolderBetweenDates(@PathVariable("ahId") Long ahId,
			@PathVariable("start") LocalDate startDate,
			@PathVariable("end") LocalDate endDate) throws TransactionException{
		return ResponseEntity.ok(txnService.getTransactionsBetweenDates(ahId, startDate, endDate));
		
	}
}
