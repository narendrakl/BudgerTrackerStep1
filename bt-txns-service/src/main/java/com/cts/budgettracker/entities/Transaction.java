package com.cts.budgettracker.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name="transactions")
public class Transaction implements Comparable<Transaction>{
   
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long txnId;
   
	private String header;
   
	private Double amount;
   
    @Enumerated(EnumType.STRING)
    private TransactionType txnType;
   
    @DateTimeFormat(iso = ISO.DATE)
    private LocalDate dateOfTxn;
   
    @ManyToOne
    private AccountHolder holder;
    
    public Transaction() {
		super();
	} 

	public Transaction(Long txnId, String header, Double amount, TransactionType txnType, LocalDate dateOfTxn,
			AccountHolder holder) {
		super();
		this.txnId = txnId;
		this.header = header;
		this.amount = amount;
		this.txnType = txnType;
		this.dateOfTxn = dateOfTxn;
		this.holder = holder;
	}


	public Long getTxnId() {
		return txnId;
	}

	public void setTxnId(Long txnId) {
		this.txnId = txnId;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public TransactionType getTxnType() {
		return txnType;
	}

	public void setTxnType(TransactionType txnType) {
		this.txnType = txnType;
	}

	public LocalDate getDateOfTxn() {
		return dateOfTxn;
	}

	public void setDateOfTxn(LocalDate dateOfTxn) {
		this.dateOfTxn = dateOfTxn;
	}

	public AccountHolder getHolder() {
		return holder;
	}

	public void setHolder(AccountHolder holder) {
		this.holder = holder;
	}

	@Override
	public int compareTo(Transaction o) {
		return this.txnId == null? 0 : this.txnId.compareTo(o.txnId);
	}
    
}
