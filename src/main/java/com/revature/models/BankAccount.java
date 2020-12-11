package com.revature.models;

import java.util.Scanner;//Scanner class to get user inputs 

public class BankAccount {
	
	private double balance;
	private String type; //checking or saving 
	
	public BankAccount(double balance, String type) {
		this.balance = balance;
		this.type = type;
	}
	
	
	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}	
	
	@Override
	public String toString() {
		return "BankAccount [type=" + type + ", balance=" + balance + "]";
	}
}
