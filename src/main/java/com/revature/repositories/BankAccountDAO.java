package com.revature.repositories;

import java.util.*;


import com.revature.models.BankAccount;
import com.revature.models.Customer;

public interface BankAccountDAO {

	
	public BankAccount addAccount(Customer c, BankAccount ba);
	
	public BankAccount removeAccount();
	
	public List<BankAccount> findAllAccounts();
	
	public BankAccount UpdateAccountBalance(Customer c, BankAccount ba);
	
}
