package com.revature.models;


public class BankAccount {
	
	private double balance;
	private String type; //checking or saving 
	public static int bankAccountId = 1;
	public int bankAccountNum; 
	
	public BankAccount() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BankAccount(double balance, String type) {
		this.balance = balance;
		this.type = type;
		bankAccountNum = bankAccountId; 
		bankAccountId++;
	}

	public int getBankAccountNum() {
		return bankAccountNum;
	}

	public void setBankAccountNum(int bankAccountNum) {
		this.bankAccountNum = bankAccountNum;
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
