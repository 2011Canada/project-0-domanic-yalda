package com.revature.models;


public class Customer extends User{
	
	public static int CustomerId = 0;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private BankAccount bankAccount;
	
	public Customer(String username, String password, String firstName, String lastName, BankAccount bankAccount){
		super();
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.bankAccount = bankAccount;
		
		// add function call that adds new instantiated customer to database
	}
	public BankAccount deposit(double depositAmount) {
		
		
		return bankAccount;
	}
	
	public BankAccount withdraw(double withdrawalAmount) {
		
		
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
