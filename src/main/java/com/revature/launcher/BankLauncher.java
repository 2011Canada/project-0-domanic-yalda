package com.revature.launcher;

import org.apache.logging.log4j.*;
import com.revature.models.BankAccount;
import com.revature.models.Customer;

public class BankLauncher {

	public static Logger bankLogger = LogManager.getLogger("com.revature.bankLogger");
	
	public static void main(String[] args) {
		
		System.out.println("Starting Banking Application");
		bankLogger.info("server is operation");
		
		
		//test one - failed - move display to seperate menu and call function to display menu
		//menu selections call other fucntions to make a bank account login, register, apply for an account ...
		Customer c = new Customer("dyalda","1234","domanic", new BankAccount(0,"checking"));
		c.applyForBankAccount();
		
		while(true) {
			//server running to get using input and server outputs
			//controller layer
			
			
		}

	}

}
