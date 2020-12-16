package com.reveture.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import com.revature.models.Customer;
import com.revature.models.BankAccount;

public class CustomerTest {

	
	private Customer c; 
	
	@BeforeEach
	public void setupCustomer() {
	    BankAccount b = new BankAccount(2000,"checking");
		this.c = new Customer("username",
				"password",
				"test",
				"user",
				b);
	}
	
	@Test 
	public void testDeposit() {
		System.out.println(c.getBankAccount().getBalance()); //checking to see if the new balance gets updated
		assertEquals(c.getBankAccount(), c.deposit(200.0) );
	}
	
	@Test 
	public void testDepositNegative() {
		System.out.println(c.getBankAccount().getBalance()); //checking to see if the new balance gets updated
		assertEquals(c.getBankAccount(), c.deposit(-200.0) );
	}//returned amount is the correct amount, depositing a negative didnt change bank balance 

	
}
