package com.cts.budgettracker.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
public class AccountHolder {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	private Long ahId;
	
	@Column(name = "fname", nullable = false)
	private String firstName;
	
	@Column(name = "lname", nullable = true)
	private String lastName;
	
	@Column(name = "emailid", nullable = false)
	private String emailId;
	
	@Column(name = "mobilenumber", nullable = false)
	private String mobileNumber;
		
	public AccountHolder() {
		super();
	}
	public Long getAhId() {
		return ahId;
	}
	public void setAhId(Long ahId) {
		this.ahId = ahId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	
	@Override
	public String toString() {
		return "AccountHolder [ahId=" + ahId + ", firstName=" + firstName + ", lastName=" + lastName + ", emailId="
				+ emailId + ", mobileNumber=" + mobileNumber + "]";
	}
	
	
}
