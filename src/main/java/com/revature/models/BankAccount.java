package com.revature.models;

public class BankAccount {
	
	private double balance;
	private String type; //checking, credit saving 
	
	public BankAccount(double balance, String type) {
		this.balance = balance;
		this.type = type;
	}

}
