package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import com.revature.launcher.BankLauncher;
import com.revature.models.BankAccount;
import com.revature.models.Customer;
import com.revature.util.ConnectionFactory;

public class CustomerPostgresDAO implements CustomerDAO {
	
	private ConnectionFactory cf = ConnectionFactory.getConnectionFactory();
	Connection conn = this.cf.getConnection();
	
	BankAccountPostgresDAO bapd = new BankAccountPostgresDAO();

	public CustomerPostgresDAO() {
		super();
	}

	public Customer addCustomer(Customer c, BankAccount b) {
		Connection conn = cf.getConnection();
		try {
			conn.setAutoCommit(false);
			
			//inserting SQL statement
			String customerSQL = "insert into \"customer\" "
					+ "(\"firstname\", \"lastname\", \"username\", \"password\")"
					+ "values (?,?,?,?) returning \"bank_account_num\";";
			PreparedStatement insertCustomer = conn.prepareStatement(customerSQL);
			
			insertCustomer.setString(1, c.getFirstName());
			insertCustomer.setString(2, c.getLastName());
			insertCustomer.setString(3, c.getUsername());
			insertCustomer.setString(4, c.getPassword());
			//insertCustomer.setInt(5, (c.getBankAccount()).bankAccountNum);
			
			ResultSet res = insertCustomer.executeQuery();
			
			if( c.getBankAccount() != null ) {
				bapd.addAccount(c, c.getBankAccount());
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();
			}catch(SQLException e1) {
				e1.printStackTrace();
			}
		}finally {	
			try {
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
			String sql = "select * from customer ;";
			
			Statement s = conn.createStatement();
			ResultSet res = s.executeQuery(sql);
			
			//while there is another row read from the db add the new customers
			while(res.next()) {
				Customer c = new Customer();
				c.setFirstName(res.getString("firstname"));
				c.setLastName(res.getString("lastname"));
				c.setUsername(res.getString("username"));
				c.setPassword(res.getString("password"));
				
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
