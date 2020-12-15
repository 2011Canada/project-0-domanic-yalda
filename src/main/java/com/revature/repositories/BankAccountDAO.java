package com.revature.repositories;

import java.util.*;

import com.revature.models.BankAccount;

public interface BankAccountDAO {

	
	//public BankAccount addAccount(BankAccount ba);
	
	public BankAccount removeAccount();
	
	public List<BankAccount> findAllAccounts();
	
	
	
}
