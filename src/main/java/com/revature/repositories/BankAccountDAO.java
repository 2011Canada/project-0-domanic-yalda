package com.revature.repositories;

import com.revature.models.BankAccount;
import com.revature.models.User;

public interface BankAccountDAO {

	
	public BankAccount addAccount();
	
	public BankAccount removeAccount();
	
	public User findAllCustomers();
	
	public User findAllEmployees();
	
	
}
