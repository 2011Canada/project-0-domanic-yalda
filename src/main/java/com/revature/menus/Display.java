package com.revature.menus;

import java.util.Scanner;
import com.revature.models.BankAccount;
import com.revature.models.Customer;
import java.util.concurrent.TimeUnit;

public class Display {

	public Display() {
		super();
	}
	
	//Generic User interacting with Banking Terminal
	public void LoginMenu() {
		String username;
		String password;
		
		System.out.println("Enter Username: \n");
		
		Scanner usernameInput = new Scanner(System.in);//creates a scanner object
		username = usernameInput.nextLine(); //reads the scanner object and assigns the value to variable
		// add function to check username input with db 
		
		System.out.println("Enter Password: \n");
		Scanner passwordInput = new Scanner(System.in);
		password = passwordInput.nextLine();
			
		//add function to check password input with db 
		
	}
	public void RegisterMenu() {
		String firstName;
		String lastName;
		String username;
		String password;
		
		System.out.println("Enter a first and last name, followed by a username and password \n");
		
		Scanner userCustomerRegisteration = new Scanner(System.in);
		firstName = userCustomerRegisteration.nextLine();
		lastName = userCustomerRegisteration.nextLine();
		username = userCustomerRegisteration.nextLine();
		password = userCustomerRegisteration.nextLine();
		
		Customer newUser = new Customer(username, password, firstName, lastName, null);
		//send customer data to db
		System.out.println("Congratulations your new customer account has been created!!! \n");
		System.out.println("Please save your Customer info for future uses:\n" + newUser.toString() + "\n");
		System.out.println("Next step to freedom banking is to apply for a bank account \n");
		CustomerMenu();
	}
	//Customer menu methods 
	public void CustomerMenu() {
		int options;
		
		System.out.println("Would you like to deposit money, withdraw money, or apply for a bank account");
		System.out.println("Enter 1 to go to the deposit menu: \n"
				+ "Enter 2 to go to withdraw menu: \n"
				+ "Enter 3 to apply for a bank account \n");
		
		Scanner userOptions = new Scanner(System.in);
		options = userOptions.nextInt();
		
		switch(options) {
			case 1:
				DepositMenu();
				break;
			case 2:
				WithdrawMenu();
				break;
			case 3:
				ApplyForBankAccount();
				break;
			default:
				System.out.println("Incorrect input try again");
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
				CustomerMenu();
		}
		
	}
	public void DepositMenu() {
		System.out.println("How Much do you want to deposit");
		//call method that implements deposit into a bank account from Customer.java 
	}
	public void WithdrawMenu() {
		System.out.println("How much would you like to withdraw");
		//call method that implements withdrawing money from a bank account from Customer.java
	}
	public void ApplyForBankAccount() { //might make it input customer that is applying for the account
		String type = "";
		double balance = 0.0;
		BankAccount bankAccount;
		System.out.println("Write the name of the account you would like to open: ");
		System.out.println("Account options:\nChecking Account\nSaving Account \n");
		
		while(true) {	
			Scanner newAccount = new Scanner(System.in); 
				type = newAccount.nextLine();
				//find a way to compare
				//System.out.println("The only accepted input is 'checking' or 'saving' ");
				if (type.equalsIgnoreCase("checking")) {
					break;
				}else if (type.equalsIgnoreCase("saving"))
					break;
			}	
		
		System.out.println("What is the inital balance you want to add to your account");
		while(balance<=0) {
			Scanner newAccount = new Scanner(System.in);
			balance = newAccount.nextDouble();

		}
		bankAccount = new BankAccount(balance, type.toLowerCase());
		//call function to send bank account info to the database/employee(undecided)
		System.out.println("The Account details are: " + bankAccount.toString());
		
	}
	// Employee menu methods 
	public void EmployeeMenu() {
		System.out.println("");
	}
}
