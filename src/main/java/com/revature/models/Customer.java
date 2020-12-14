package com.revature.models;

import java.util.*;

public class Customer extends User{
	
	public static int CustomerId = 0;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private BankAccount bankAccount;
	
	
	public Customer() {
		super();
	}
	
	public Customer(String username, String password, String firstName, String lastName, BankAccount bankAccount){
		super();
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.bankAccount = bankAccount;
		
		// add function call that adds new instantiated customer to database
	}
	
	public String getPassword() {
		return password;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setBankAccount(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}
	
	public BankAccount deposit(double depositAmount) {
		BankAccount b = this.bankAccount;
		
		b.setBalance(b.getBalance() + depositAmount);
		
		//send new updated bank account info into the db
		System.out.println("Your new BankAccount balance is: " + bankAccount.getBalance());
		return bankAccount;
	}
	
	public BankAccount withdraw(double withdrawalAmount) {
		BankAccount b = this.bankAccount;
		
		if (withdrawalAmount > b.getBalance()) {
			System.out.println("You are too poor to withdraw that much money");
		}else {
			b.setBalance(b.getBalance() - withdrawalAmount);
		}
		//send new updated bank account info into the db
		System.out.println("Your BankAccount balance is: " + bankAccount.getBalance());	
		return bankAccount;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	//to change the password
	public void setPassword(String password) {
		this.password = password;
	}
	
	// only getters for names because you shouldn't be able to change your name
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	

	public int getBankAccountId() {
		return bankAccount.bankAccountId;
	}

	public BankAccount getBankAccount() {
		return bankAccount;
	}

	public void setBankAccounts(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
		
	}

	public static int getCustomerId() {
		return CustomerId;
	}
	
	@Override
	public String toString() {
		return "Customer [username=" + username + ", password=" + password + ", firstName=" + firstName + ", lastName="
				+ lastName + ", bankAccount=" + bankAccount + "]";
	}
	
}
