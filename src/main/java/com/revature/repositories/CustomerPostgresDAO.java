package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import com.revature.launcher.BankLauncher;
import com.revature.models.Customer;
import com.revature.util.ConnectionFactory;

public class CustomerPostgresDAO implements CustomerDAO {
	
	private ConnectionFactory cf = ConnectionFactory.getConnectionFactory();
	Connection conn = this.cf.getConnection();

	public CustomerPostgresDAO() {
		super();
	}

	public Customer addCustomer(Customer c) {
		Connection conn = cf.getConnection();
		try {
			conn.setAutoCommit(false);
			
			//inserting SQL statement
			String CustomerSQL = "insert into \"Customer\" "
					+ "(\"firstname\", \"lastname\", \"username\", \"password\", \"bank_account_id\")"
					+ "values (?,?,?,?,?) returning \"customer_id\";";
			PreparedStatement insertCustomer = conn.prepareStatement(CustomerSQL);
			
			insertCustomer.setString(2, c.getFirstName());
			insertCustomer.setString(3, c.getLastName());
			insertCustomer.setString(4, c.getUsername());
			insertCustomer.setString(5, c.getPassword());
			insertCustomer.setObject(6, c.getBankAccount());
			
			insertCustomer.executeQuery();	
		}catch(SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();
			}catch(SQLException e1) {
				e1.printStackTrace();
			}
		}finally {	
			try {
				conn.commit();
				conn.setAutoCommit(true);
			}catch(SQLException e){
				e.printStackTrace();
			}
			cf.releaseConnection(conn);
		}
		//returns the data of the customer that should be in the db now. 
		return c;
	}

	public List<Customer> findAllCustomers() {
		Connection conn = this.cf.getConnection();
		List<Customer> allCustomers = new ArrayList<Customer>();
		try {
			String sql = "select * from Customer;";
			
			Statement s = conn.createStatement();
			ResultSet res = s.executeQuery(sql);
			
			//while there is another row read from the db add the new customers
			while(res.next()) {
				Customer c = new Customer();
				c.setFirstName(res.getString("firstname"));
				c.setLastName(res.getString("lastname"));
				c.setUsername(res.getString("username"));
				c.setPassword(res.getString("password"));
				//c.setBankAccount(res.getObject("bank_account_id")); //reference index to bank account object
				allCustomers.add(c);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			cf.releaseConnection(conn);
		}
		BankLauncher.bankLogger.info(allCustomers);
		return allCustomers;
	}

}
