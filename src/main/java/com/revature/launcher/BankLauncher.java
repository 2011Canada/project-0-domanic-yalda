package com.revature.launcher;

import com.revature.menus.Display;

import java.sql.Connection;

import org.apache.logging.log4j.*;
import com.revature.models.*;
import com.revature.repositories.BankAccountPostgresDAO;
import com.revature.repositories.CustomerPostgresDAO;
import com.revature.util.ConnectionFactory;

public class BankLauncher {

	public static Logger bankLogger = LogManager.getLogger("com.revature.bankLogger");
	
	public static void main(String[] args) {
		
		
		System.out.println("Starting Banking Application");
		bankLogger.info("server is operation");
		
		CustomerPostgresDAO  cpd = new CustomerPostgresDAO();
		BankAccountPostgresDAO bapd = new BankAccountPostgresDAO();
		
		
		//used to test if there will be an error trying to connect to the database.
		//ConnectionFactory cf = ConnectionFactory.getConnectionFactory();
		//Connection conn = cf.getConnection();
		
		
		
		Customer cust = new Customer("dyalda","1234","domanic","yalda", new BankAccount(1000,"checking"));
		
		Customer cust2 = new Customer("dyalda1","12345","domanic1","yalda2", new BankAccount(100,"checking"));
		Customer cust3= new Customer("dyalda2","123456","domanic2","yalda3", new BankAccount(10,"checking"));
		Customer cust4 = new Customer("dyalda3","1234567","domanic3","yalda4", new BankAccount(1,"checking"));
		System.out.println(cust.getBankAccountNum()+ " " 
					+ cust2.getBankAccountNum() + " "  
					+ cust3.getBankAccountNum() + " " 
					+ cust4.getBankAccountNum());
		
		System.out.println(cust.getBankAccountNum()+ " " 
				+ cust2.getBankAccount().getBalance() + " "  
				+ cust3.getBankAccount().getBalance() + " " 
				+ cust4.getBankAccount().getBalance());

		 //checked incrementing bank account num every time a customer gets one.
		
		cpd.addCustomer(cust, cust.getBankAccount());
		cpd.addCustomer(cust2, cust2.getBankAccount());
		cpd.addCustomer(cust3, cust3.getBankAccount());
		cpd.addCustomer(cust4, cust4.getBankAccount());
		
		cpd.findAllCustomers();
		/*
		bapd.addAccount(cust, cust.getBankAccount());
		bapd.addAccount(cust2, cust2.getBankAccount());
		bapd.addAccount(cust3, cust3.getBankAccount());
		bapd.addAccount(cust4, cust4.getBankAccount());
		
		/*  testing the deposit and withdraw functions
		cust.deposit(2000);
		System.out.println(cust.toString());
		cust.withdraw(2000);
		System.out.println(cust.toString());
		cust.withdraw(5000);
		*/
		
		//cust.applyForBankAccount();
		//System.out.println(cust.toString());
		
		//Display disp = new Display();
		//disp.LoginMenu();
		//disp.CustomerMenu();
		while(true) {
			
			//server running to get using input and server outputs
			//controller layer
			
			
			
			
			break;
			
			
		}

	}

}
