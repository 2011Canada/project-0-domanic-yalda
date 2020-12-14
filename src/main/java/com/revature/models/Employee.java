package com.revature.models;

public class Employee extends User{
	
	private static int employeeId;
	private String firstName;
	private String lastName;
	private String password;
	
	public Employee(String firstName, String lastName, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		employeeId++;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", password=" + password + "]";
	}
	
}
