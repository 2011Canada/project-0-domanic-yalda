package com.revature.menus;

import java.util.Scanner;
import com.revature.models.BankAccount;
import com.revature.repositories.CustomerPostgresDAO;
import com.revature.repositories.BankAccountPostgresDAO;
import com.revature.repositories.EmployeePostgresDAO;
import com.revature.services.CustomerServiceImplementation;
import com.revature.services.EmployeeServiceImplementation;
import com.revature.models.*;
import java.util.concurrent.TimeUnit;

public class Display {
	
	CustomerPostgresDAO cpd = new CustomerPostgresDAO();
	CustomerServiceImplementation csi = new CustomerServiceImplementation();
	EmployeeServiceImplementation esi = new EmployeeServiceImplementation();
	
	BankAccountPostgresDAO bapd = new BankAccountPostgresDAO();
	
	
	public Display() {
		super();
	}
	
	public void MainMenu() {
		int option;
		System.out.println("Select 1 to Login \n"
				+ "Select 2 to Register");
		Scanner userInput = new Scanner(System.in);
		option = userInput.nextInt();
		if(option == 1) {
			LoginMenu();
		}else if (option == 2) {
			RegisterMenu();
		}
	}
	
	//Generic User interacting with Banking Terminal works
	public void LoginMenu() {
		Customer c = new Customer();
		Employee e = new Employee();
		String username;
		String password;
		
		System.out.println("Enter Username: \n");
		
		Scanner usernameInput = new Scanner(System.in);//creates a scanner object
		username = usernameInput.nextLine(); //reads the scanner object and assigns the value to variable
		
		// add function to check username input with db 
		
		System.out.println("Enter Password: \n");
		Scanner passwordInput = new Scanner(System.in);
		password = passwordInput.nextLine();
		c.setUsername(username);
		c.setPassword(password);
		e.setEmployeeNum(Integer.parseInt(username));//since an employee logs in with their employee id, the username input is passed as an int
		e.setPassword(password);	
		//add function to check password input with db
		//checks the employee and customer tables 
		
		if (csi.LoginCheck(c) == true) {
			CustomerMenu();
			
		}else if (esi.LoginCheck(e) == true){
			EmployeeMenu();
		}else {
			System.out.println("Invalid Customer login info returning to the Main Menu");
			MainMenu();
		}
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
				+ "Enter 3 to apply for a bank account \n"
				+ "Enter 4 to view current account balance \n"
				+ "Enter 5 to transfer money to another customer \n");
		
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
			case 4:
				//view current balance
				break;
			case 5:
				//TransferMoney();
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
	
	public void TransferMoney(Customer c1, Customer c2) {
		
	}
	
	// Employee menu methods 
	public void EmployeeMenu() {
		int options;
		System.out.println("Enter 1 to view all current bank accounts "
				+ "2 to view all the current customers "
				+ "3 to view a log of all the details"
				+ "4 to leave the Employee Menu");
		Scanner employeeInput = new Scanner(System.in);
		options = employeeInput.nextInt();
		if (options==1) {
			bapd.findAllAccounts();
			EmployeeMenu();
		}else if(options == 2) {
			cpd.findAllCustomers();
			EmployeeMenu();
		}else if (options == 3) {
			//print out the logs
			EmployeeMenu();
		}else if (options ==4) {
			LoginMenu();
		}else {
			System.out.println("incorrect input try again");
			EmployeeMenu();
		}
	}
}
