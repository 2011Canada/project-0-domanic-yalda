package com.revature.repositories;

import com.revature.models.BankAccount;
import com.revature.models.Customer;

public interface CustomerDAO {

	
	public Customer addCustomer(Customer c);
	public Customer findAllCustomers();
	
}
