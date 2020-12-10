package com.revature.models;

import java.util.Scanner;//Scanner class to get user inputs 

public class BankAccount {
	
	private double balance;
	private String type; //checking or saving 
	
	public BankAccount(double balance, String type) {
		this.balance = balance;
		this.type = type;
	}

	@Override
	public String toString() {
		return "BankAccount [type=" + type + ", balance=" + balance + "]";
	}
	
	public BankAccount applyForBankAccount() {
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
		return bankAccount;
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
}
