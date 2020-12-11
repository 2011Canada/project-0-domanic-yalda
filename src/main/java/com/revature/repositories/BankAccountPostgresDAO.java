package com.revature.repositories;

import java.sql.Connection;

import com.revature.models.BankAccount;
import com.revature.models.User;
import com.revature.util.ConnectionFactory;

public class BankAccountPostgresDAO implements BankAccountDAO{

	private ConnectionFactory cf = ConnectionFactory.getConnectionFactory();
	Connection conn = this.cf.getConnection();
	
	public BankAccount addAccount() {
		
		Connection conn = cf.getConnection();
		
		return null;
	}
	public BankAccount removeAccount() {
		// TODO Auto-generated method stub
		return null;
	}
	public User findAllCustomers() {
		// TODO Auto-generated method stub
		return null;
	}
	public User findAllEmployees() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
