package com.revature.services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.revature.menus.Display;
import com.revature.models.Employee;
import com.revature.util.ConnectionFactory;

public class EmployeeServiceImplementation implements EmployeeService{

	private ConnectionFactory cf = ConnectionFactory.getConnectionFactory();
	Connection conn = this.cf.getConnection();
	
	
	public EmployeeServiceImplementation() {
		super();
	}
	
	public boolean LoginCheck(Employee e) {
		Connection conn = this.cf.getConnection();
		try {
			String sql = "select * from employee where (( employee_id = " + e.getEmployeeNum() +") and (password = '"+ e.getPassword() +"' ));";
			
			Statement s = conn.createStatement();
			ResultSet res = s.executeQuery(sql);
			
			if(res.next()) {
				return true;
			}	
		}catch(SQLException e1){
			e1.printStackTrace();
		}finally {
			cf.releaseConnection(conn);
		}
		//BankLauncher.bankLogger.info(allCustomers);
		return false;
	}
	public Display RegisterMenu() {
		// TODO Auto-generated method stub
		return null;
	}


}
