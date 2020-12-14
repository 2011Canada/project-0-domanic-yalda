package com.revature.repositories;

import java.util.List;

import com.revature.models.BankAccount;
import com.revature.models.Customer;


public interface CustomerDAO {

	
	public Customer addCustomer(Customer c);
	public List<Customer> findAllCustomers();
	
}
