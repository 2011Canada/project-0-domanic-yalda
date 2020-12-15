package com.revature.menus;

import java.util.Scanner;
import com.revature.models.BankAccount;
import com.revature.repositories.CustomerPostgresDAO;
import com.revature.repositories.BankAccountPostgresDAO;
import com.revature.repositories.EmployeePostgresDAO;
import com.revature.services.CustomerServiceImplementation;
import com.revature.models.*;
import java.util.concurrent.TimeUnit;

public class Display {
	
	CustomerPostgresDAO cpd = new CustomerPostgresDAO();
	CustomerServiceImplementation csi = new CustomerServiceImplementation();
	
	public Display() {
		super();
	}
	
	
	//Generic User interacting with Banking Terminal
	public Customer LoginMenu(Customer c) {
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
		
		if (csi.LoginMenu(c) == true) {
			return c;
		}else {
			System.out.println("Invalid Customer login info");
		}
		
		return null;
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

		//adding the registered user into the db
		cpd.addCustomer(newUser, newUser.getBankAccount());
		
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
	public double DepositMenu() {
		double depositAmount;
		
		System.out.println("How Much do you want to deposit");
		
		Scanner depositInput = new Scanner(System.in);
		depositAmount = depositInput.nextDouble();
		
		// when a user invokes the deposit method they will be taken into this menu to get the deposit amount
		return depositAmount;
	}
	
	public double WithdrawMenu() {
		double withdrawalAmount;
		System.out.println("How much would you like to withdraw");
		
		Scanner withdrawalInput = new Scanner(System.in);
		withdrawalAmount = withdrawalInput.nextDouble();
		
		return withdrawalAmount;
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
