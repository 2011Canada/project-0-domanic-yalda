package com.revature.launcher;

import com.revature.menus.Display;
import org.apache.logging.log4j.*;
import com.revature.models.*;
import com.revature.repositories.CustomerPostgresDAO;


public class BankLauncher {

	public static Logger bankLogger = LogManager.getLogger("com.revature.bankLogger");
	
	public static void main(String[] args) {
		
		
		System.out.println("Starting Banking Application");
		bankLogger.info("server is operation");
		
		CustomerPostgresDAO  cpd = new CustomerPostgresDAO();
		Display disp = new Display();
		
		
		Customer vipMember = new Customer("dy","1234","domanic","yalda", new BankAccount(1000000,"checking"));
		cpd.addCustomer(vipMember, vipMember.getBankAccount());
		while(true) {
			
			//server running to get using input and server outputs
			//controller layer
			
			disp.MainMenu();
			
			break;
			
			
			
		}

	}

}
