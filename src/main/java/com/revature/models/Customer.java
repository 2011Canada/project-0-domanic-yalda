package com.revature.models;

import java.util.*;

public class Customer extends User{
	
	public static int CustomerId = 0;
	private String username;
	private String password;
	private String legalName;
	private List<BankAccount> bankAccounts = new ArrayList<BankAccount>();
	
	public Customer(String username, String password, String legalName, List<BankAccount> bankAccounts) {
		super();
		this.username = username;
		this.password = password;
		this.legalName = legalName;
		this.bankAccounts = bankAccounts;
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
	
	//can only get legal name since you shouldn't be able to change your legal nam on ur banking information
	public String getLegalName() {
		return legalName;
	}

	public List<BankAccount> getBankAccounts() {
		return bankAccounts;
	}

	public void setBankAccounts(List<BankAccount> bankAccounts) {
		this.bankAccounts = bankAccounts;
	}

	public static int getCustomerId() {
		return CustomerId;
	}


	
	
	

}
