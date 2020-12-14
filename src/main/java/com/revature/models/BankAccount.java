package com.revature.models;


public class BankAccount {
	
	private double balance;
	private String type; //checking or saving 
	private static int bankAccountId = 0;
	
	public BankAccount(double balance, String type) {
		this.balance = balance;
		this.type = type;
		bankAccountId++;
	}
	
	public BankAccount() {
		super();
		// TODO Auto-generated constructor stub
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
