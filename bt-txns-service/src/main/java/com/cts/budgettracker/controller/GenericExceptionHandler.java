package com.cts.budgettracker.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cts.budgettracker.entities.Transaction;
import com.cts.budgettracker.exception.TransactionException;

@RestControllerAdvice
public class GenericExceptionHandler {
	
	@ExceptionHandler(TransactionException.class)
	public ResponseEntity<String> handleUserDefinedException(TransactionException exp){
		return new ResponseEntity<String>(exp.getMessage(),HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleSystemException(Exception exp){
		return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
