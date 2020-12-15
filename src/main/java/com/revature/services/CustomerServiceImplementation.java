package com.revature.services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.launcher.BankLauncher;
import com.revature.menus.Display;
import com.revature.models.Customer;
import com.revature.util.ConnectionFactory;

public class CustomerServiceImplementation implements CustomerService{

	private ConnectionFactory cf = ConnectionFactory.getConnectionFactory();
	Connection conn = this.cf.getConnection();

	public CustomerServiceImplementation() {
		super();
	}

	public boolean LoginMenu(Customer c) {
		Connection conn = this.cf.getConnection();
		try {
			String sql = "select * from customer where (username =" +c.getUsername() +") AND (password = "+ c.getPassword() +" ));";
			
			Statement s = conn.createStatement();
			ResultSet res = s.executeQuery(sql);
			
			if(res.next()) {
				return true;
			}	
		}catch(SQLException e){
			e.printStackTrace();
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
