package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import com.revature.launcher.BankLauncher;
import com.revature.models.BankAccount;
import com.revature.util.ConnectionFactory;

public class BankAccountPostgresDAO implements BankAccountDAO{

	private ConnectionFactory cf = ConnectionFactory.getConnectionFactory();
	Connection conn = this.cf.getConnection();
	
	public BankAccount addAccount(BankAccount ba) {
		
		Connection conn = cf.getConnection();
		try {
			conn.setAutoCommit(false);
			
			//inserting SQL statement
			String bankAccountSQL = "insert into \"Bank_Account\" "
					+ "(\"balance\", \"type\" )"
					+ "values (?,?) returning \"bank_account_id\";";
			//using the prepared statement allows for the use of provided params
			PreparedStatement insertBankAccount = conn.prepareStatement(bankAccountSQL);
			
			insertBankAccount.setDouble(2, ba.getBalance());
			insertBankAccount.setString(3, ba.getType());
			
			insertBankAccount.executeQuery();
		}
		catch(SQLException e){
			e.printStackTrace();
			try {
				conn.rollback();
			}catch(SQLException e1) {
				e1.printStackTrace();
			}
		}
		finally{
			try {
				conn.commit();
				conn.setAutoCommit(true);
			}catch(SQLException e){
				e.printStackTrace();
			}
			cf.releaseConnection(conn);
		}
		
		//this should return the original object after its fields have been added to the db
		return ba;
	}

	public List<BankAccount> findAllAccounts() {
		Connection conn = this.cf.getConnection();
		List<BankAccount> allAccounts = new ArrayList<BankAccount>();
		
		try {
			String sql = "select * from Bank_Accounts;";
			
			//for very basic sql queries a statement is used
			Statement s = conn.createStatement();
			ResultSet res = s.executeQuery(sql);
			
			//while there is another row in the db.
			//resultset, starts at before the first row. it goes to the first row after u call next
			while(res.next()) {
				//adding in new bank accounts
				BankAccount b = new BankAccount();
				b.setBalance(res.getDouble("balance"));
				b.setType(res.getString("type"));
				allAccounts.add(b);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			cf.releaseConnection(conn);
		}
		BankLauncher.bankLogger.info(allAccounts);
		return allAccounts;
	}
	
	//unimplemented atm 
	public BankAccount removeAccount() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
