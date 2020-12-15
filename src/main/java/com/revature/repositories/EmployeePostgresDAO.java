package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.launcher.BankLauncher;
import com.revature.models.BankAccount;
import com.revature.models.Customer;
import com.revature.models.Employee;
import com.revature.util.ConnectionFactory;

public class EmployeePostgresDAO implements EmployeeDAO{

	private ConnectionFactory cf = ConnectionFactory.getConnectionFactory();
	Connection conn = this.cf.getConnection();
	
	public Employee addEmployee(Employee e) {
		Connection conn = cf.getConnection();
		try {
			conn.setAutoCommit(false);
			
			//inserting SQL statement
			String customerSQL = "insert into \"customer\" "
					+ "(\"firstname\", \"lastname\", \"employee_id\", \"password\")"
					+ "values (?,?,?,?)";
			PreparedStatement insertEmployee = conn.prepareStatement(customerSQL);
			
			insertEmployee.setString(1, e.getFirstName());
			insertEmployee.setString(2, e.getLastName());
			insertEmployee.setInt(3, e.getEmployeeNum());
			insertEmployee.setString(4, e.getPassword());			
			insertEmployee.executeUpdate();
			
		}catch(SQLException e1) {
			e1.printStackTrace();
			try {
				conn.rollback();
			}catch(SQLException e2) {
				e2.printStackTrace();
			}
		}finally {	
			try {
				conn.setAutoCommit(true);
			}catch(SQLException e1){
				e1.printStackTrace();
			}
			cf.releaseConnection(conn);
		}
		//returns the data of the customer that should be in the db now. 
		return e;
	}

	public List<Employee> findAllEmployees() {
		Connection conn = this.cf.getConnection();
		List<Employee> allEmployees = new ArrayList<Employee>();
		try {
			String sql = "select * from employee ;";
			
			Statement s = conn.createStatement();
			ResultSet res = s.executeQuery(sql);
			
			//while there is another row read from the db add the new customers
			while(res.next()) {
				Employee e = new Employee();
				e.setFirstName(res.getString("firstname"));
				e.setLastName(res.getString("lastname"));
				e.setEmployeeNum(res.getInt("employee_id"));
				e.setPassword(res.getString("password"));
				
				allEmployees.add(e);
			}
		}catch(SQLException e1){
			e1.printStackTrace();
		}finally {
			cf.releaseConnection(conn);
		}
		BankLauncher.bankLogger.info(allEmployees);
		return allEmployees;
	}


}
