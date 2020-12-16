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
		
		
		Customer vipMember1 = new Customer("jb","1234","jeff","bezos", new BankAccount(100000001,"checking"));
		cpd.addCustomer(vipMember1, vipMember1.getBankAccount());
		Customer vipMember2 = new Customer("bg","4321","bill","gates", new BankAccount(100000000,"checking"));
		cpd.addCustomer(vipMember2, vipMember2.getBankAccount());
		
		//disp.TransferMoney(vipMember1, vipMember2); tested working transfer function no db connections
		while(true) {
			
			//server running to get using input and server outputs
			//controller layer
			
			disp.MainMenu();
			
			break;	
			
		}

	}

}
