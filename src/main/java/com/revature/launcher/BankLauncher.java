package com.revature.launcher;

import com.revature.menus.Display;

import java.sql.Connection;

import org.apache.logging.log4j.*;
import com.revature.models.*;
import com.revature.repositories.CustomerPostgresDAO;
import com.revature.util.ConnectionFactory;

public class BankLauncher {

	public static Logger bankLogger = LogManager.getLogger("com.revature.bankLogger");
	
	public static void main(String[] args) {
		
		
		System.out.println("Starting Banking Application");
		bankLogger.info("server is operation");
		
		CustomerPostgresDAO  cpd = new CustomerPostgresDAO();
		
		
		//used to test if there will be an error trying to connect to the database.
		//ConnectionFactory cf = ConnectionFactory.getConnectionFactory();
		//Connection conn = cf.getConnection();
		
		Customer cust = new Customer("dyalda","1234","domanic","yalda", new BankAccount(1000,"checking"));
		cpd.addCustomer(cust);
		
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
