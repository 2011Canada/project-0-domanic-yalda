package com.revature.models;

import java.util.*;

public class Customer extends User{
	
	public static int CustomerId = 0;
	private String username;
	private String password;
	private String legalName;
	private BankAccount bankAccount;
	
	public Customer(String username, String password, String legalName, BankAccount bankAccount){
		super();
		this.username = username;
		this.password = password;
		this.legalName = legalName;
		this.bankAccount = bankAccount;
	}
	
	public String applyForBankAccount() {
		String type = "";		
		double balance = 0;
		BankAccount bankAccount;
		System.out.println("Choose what type of account you want to apply for: ");
		System.out.println("Account options: /n 1. Checking Account /n 2. Savings Account /n 3. Credit ");
		
		while(!type.equals("checking") || !type.equals("saving")) {	
			Scanner newCustomer = new Scanner(System.in);
			if (newCustomer.hasNext()) {
				newCustomer = new Scanner(System.in);	
			}	
		}
		System.out.println("What is the inital balance you want to add to your account");
		while(balance<=0) {
			Scanner newCustomer = new Scanner(System.in);
			if(newCustomer.hasNextDouble()) {
				balance = newCustomer.nextDouble();	
			}
		}
		bankAccount = new BankAccount(balance, type);
		//call function to send bank account info to the database
		
		return bankAccount.toString();
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
	
	//can only get legal name since you shouldn't be able to change your legal name on your banking information
	public String getLegalName() {
		return legalName;
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


	

}
