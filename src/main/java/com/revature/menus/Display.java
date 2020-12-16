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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Display {
	
	public static Logger bankLogger = LogManager.getLogger("com.revature.bankLogger");
	
	CustomerPostgresDAO cpd = new CustomerPostgresDAO();
	CustomerServiceImplementation csi = new CustomerServiceImplementation();
	EmployeeServiceImplementation esi = new EmployeeServiceImplementation();
	BankAccountPostgresDAO bapd = new BankAccountPostgresDAO();
	
	Customer newUser = new Customer();
	
	public Display() {
		super();
	}
	
	public void MainMenu() {
		int option = 0 ;
		System.out.println("Select 1 for Customer Login \n"
				+ "Select 2 to Register \n"
				+ "Select 3 for Employee Login");
		while((option !=1) && (option !=2) && (option !=3)){
		Scanner userInput = new Scanner(System.in);
		option = userInput.nextInt();
		}
		if(option == 1) {
			LoginMenu();
		}else if (option == 2) {
			RegisterMenu();
		}else if (option == 3) {
			EmployeeLogin();
		}
	}
	//Generic User interacting with Banking Terminal works
	public void EmployeeLogin() {
		Employee e = new Employee();
		int employeeId;
		String password;
		
		System.out.println("Enter Employee Number: \n");
		Scanner employeeIdInput = new Scanner(System.in);//creates a scanner object
		employeeId = employeeIdInput.nextInt(); //reads the scanner object and assigns the value to variable	
		System.out.println("Enter Password: \n");
		Scanner passwordInput = new Scanner(System.in);
		password = passwordInput.nextLine();
		
		e.setEmployeeNum(employeeId);
		e.setPassword(password);
		e.setPassword(password);	
		
		//checks the employee tables 
		if (esi.LoginCheck(e) == true){
			EmployeeMenu();
		}else {
			System.out.println("Invalid Customer login info returning to the Main Menu");
			MainMenu();
		}
	}
	
	//Generic User interacting with Banking Terminal works
	public void LoginMenu() {
		Customer c = new Customer();
		String username;
		String password;
		
		System.out.println("Enter Username: \n");
		
		Scanner usernameInput = new Scanner(System.in);//creates a scanner object
		username = usernameInput.nextLine(); //reads the scanner object and assigns the value to variable	
		System.out.println("Enter Password: \n");
		Scanner passwordInput = new Scanner(System.in);
		password = passwordInput.nextLine();
		c.setUsername(username);
		c.setPassword(password);		
		if (csi.LoginCheck(c) == true) {
			CustomerMenu();
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
		//a customer has to register, but an employee gets an id when they're hired along with their password for login details to be added
		this.newUser = newUser;
		bankLogger.info("A new Customer has been added into the system " + newUser.toString());
		
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
				+ "Enter 5 to transfer money to another customer \n"
				+ "Enter 6 to Logout");
		
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
				try {
				System.out.println("The current balance in your account is: " +newUser.getBankAccount().getBalance());
				CustomerMenu();
				}catch(NullPointerException n){
					System.out.println("You currently do not have a bank Account");
					CustomerMenu();
				}
				break;
			case 5:
				//TransferMoney();
				break;
			case 6:
				MainMenu();
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
		double depositAmount;
		
		System.out.println("How Much do you want to deposit");
		
		Scanner depositInput = new Scanner(System.in);
		depositAmount = depositInput.nextDouble();
		
		//when accessing the depsit or withdraw menus they call upon the deposit and withdraw methods from the customer model.
		newUser.deposit(depositAmount);
		try {
		System.out.println("New Balance is: " + newUser.getBankAccount().getBalance());
		}catch(NullPointerException n) {
			System.out.println("You do not currently have an account, go apply for an account");
			CustomerMenu();
		}
		//updates the bank account balance on the db
		bapd.UpdateAccountBalance(newUser, newUser.getBankAccount());
		bankLogger.info("The Customer " + newUser.getFirstName()+ " deposited: " + depositAmount);
		CustomerMenu();
	}
	
	public void WithdrawMenu() {
		double withdrawalAmount;
		System.out.println("How much would you like to withdraw");
		
		Scanner withdrawalInput = new Scanner(System.in);
		withdrawalAmount = withdrawalInput.nextDouble();
		
		newUser.withdraw(withdrawalAmount);
		try {
		System.out.println("New Balance is: " + newUser.getBankAccount().getBalance());
		}catch(NullPointerException n) {
			System.out.println("You do not currently have an account, go open apply for an account ");
			CustomerMenu();
		}
		// updates the bank account balance on the db 
		bapd.UpdateAccountBalance(newUser, newUser.getBankAccount());
		bankLogger.info("The Customer " + newUser.getFirstName()+ " withdrew: " + withdrawalAmount);
		CustomerMenu();
	}
	
	public void ApplyForBankAccount() {
		String type = "";
		double balance = 0.0;
		BankAccount bankAccount;
		System.out.println("Write the name of the account you would like to open: ");
		System.out.println("Account options:\nChecking Account\nSaving Account \n");
		
		while(true) {	
			Scanner newAccount = new Scanner(System.in); 
				type = newAccount.nextLine();
				//System.out.println("The only accepted input is 'checking' or 'saving' ");
				if (type.equalsIgnoreCase("checking")) {
					break;
				}else if (type.equalsIgnoreCase("saving"))
					break;
			}	
		
		System.out.println("What is the inital balance you want to add to your account. \n"
				+ "Our Employee Rules state: The system will cannot allow you to have a starting balance lower then $2000");
		while(balance<=2000) {
			Scanner newAccount = new Scanner(System.in);
			balance = newAccount.nextDouble();

		}
		
		bankAccount = new BankAccount(balance, type.toLowerCase());
		this.newUser.setBankAccount(bankAccount);
		//sending the new bank account info to the db
		bapd.addAccount(newUser, bankAccount);
		System.out.println("The Account details are: " + bankAccount.toString());
		bankLogger.info("The Customer " + newUser.getFirstName()+ " applied for a new bank account with details: " + bankAccount.toString());
		CustomerMenu();
	}
	
	public void TransferMoney(Customer c1, Customer c2) {
		double amountToTransfer;
		boolean check;
		System.out.println("Enter how much money you wish to transfer");
		Scanner transferInput = new Scanner(System.in);
		amountToTransfer = transferInput.nextDouble();
		if (amountToTransfer>(c1.getBankAccount().getBalance())) {
			System.out.println("Cannot transfer more money than what you have in your account"); 
		}else if (amountToTransfer<(c1.getBankAccount().getBalance())) {
			double c1NewBalance = c1.getBankAccount().getBalance();
			double c2NewBalance = c2.getBankAccount().getBalance();
			c1NewBalance = c1NewBalance - amountToTransfer;
			c2NewBalance = c2NewBalance + amountToTransfer;
			c1.getBankAccount().setBalance(c1NewBalance);
			c2.getBankAccount().setBalance(c2NewBalance);
			
			check = AcceptTransfer();
			if (check == true ) {
			c2.getBankAccount().setBalance(c2NewBalance);
			bankLogger.info("The Customer with details " + c1.toString() + " transfered "+ amountToTransfer + " to: " + c2.toString()); 
			
			}else {
				System.out.println("declined money transfer");
				//cancels transfer and reverts account balances to original values to how it was before
				c1NewBalance = c1NewBalance + amountToTransfer;
				c2NewBalance = c2NewBalance - amountToTransfer;
				c1.getBankAccount().setBalance(c1NewBalance);
				c2.getBankAccount().setBalance(c2NewBalance);
				
			}
			
			System.out.println("Your balance after transfer then money is: " + c1.getBankAccount().getBalance());
		}
		
	}
	// optional accept or decline money transfered
	public boolean AcceptTransfer() {
		int option = 0;
		System.out.println("Select 1 to accept money being transfered"
				+ "Select 2 to decline the money transfer");
		while ((option != 1) &&(option !=2)) {
		Scanner choiceInput = new Scanner(System.in);
		option = choiceInput.nextInt();
		
		}
		if (option == 1) {
			return true;
		}else if (option ==2) {
			return false;
		}
		return true;
	}
	
	// Employee menu methods 
	public void EmployeeMenu() {
		int options;
		System.out.println("Enter 1 to view all current bank accounts \n"
				+ "2 to view all the current customers \n"
				+ "3 to view a log of all the details\n"
				+ "4 to logout and return back to the main menu \n");
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
			MainMenu();
		}else {
			System.out.println("incorrect input try again");
			EmployeeMenu();
		}
	}
}
