package com.revature.launcher;

import com.revature.menus.Display;
import org.apache.logging.log4j.*;
import com.revature.models.BankAccount;
import com.revature.models.Customer;

public class BankLauncher {

	public static Logger bankLogger = LogManager.getLogger("com.revature.bankLogger");
	
	public static void main(String[] args) {
		
		System.out.println("Starting Banking Application");
		bankLogger.info("server is operation");
		
		
		//Customer cust = new Customer("dyalda","1234","domanic","yalda", new BankAccount(0,"checking"));
		//cust.applyForBankAccount();
		//System.out.println(cust.toString());
		
		Display disp = new Display();
		//disp.LoginMenu();
		disp.CustomerMenu();
		while(true) {
			
			//server running to get using input and server outputs
			//controller layer
			
			
			
			break;
			
			
		}

	}

}
