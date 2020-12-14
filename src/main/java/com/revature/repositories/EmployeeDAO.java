package com.revature.repositories;

import com.revature.models.BankAccount;
import com.revature.models.Employee;

public interface EmployeeDAO {

	public Employee addEmployee(Employee e);
	public Employee findEmployee();
}
