package com.revature.services;

import com.revature.menus.Display;
import com.revature.models.Employee;

public interface EmployeeService {

	public boolean LoginCheck(Employee e);
	public Display RegisterMenu();
	
}
