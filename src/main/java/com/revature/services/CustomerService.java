package com.revature.services;

import com.revature.menus.Display;
import com.revature.models.Customer;

public interface CustomerService{
		
		public boolean LoginCheck(Customer c);
		public Display RegisterMenu();
	}


