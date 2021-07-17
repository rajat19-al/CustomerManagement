package com.mycompany.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.List;

import com.mycomany.model.Customer;
import com.mycomany.service.CustomerService;
import com.mycomany.service.CustomerServiceImpl;
import com.mycompany.dto.CustomerDto;

public class MainCli {
	private static CustomerService customerService = new CustomerServiceImpl();

	public static void main(String[] args) throws SQLException, IOException {
		char selection2 = ' ';
		do {
			
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("------------------------------------");
		System.out.println("------ Customer Management Application -------");
		System.out.println("------ 1. Add Customer Details ------");
		System.out.println("------ 2. Retrieve all Customers ------");
		System.out.println("------ 3. Retrieve Customers by ID ------");
		System.out.println("------ 4. Update Customer Details ------");
		System.out.println("------ 5. Delete Customer Details ------");
		int choice = 0;
		System.out.println(" Enter your choice from Above ");
		choice = Integer.parseInt(br.readLine());
		switch (choice) {
		case 1:
			char selection = ' ';
			do {
			System.out.println("Enter Customer details");
			System.out.println("Enter customer First Name");
			String fName = br.readLine();
			System.out.println("Enter customer Last Name");
			String lName = br.readLine();
			System.out.println("Enter customer Age");
			int age = Integer.parseInt(br.readLine());
			System.out.println("Enter customer Address");
			String address = br.readLine();
			System.out.println("Enter customer Email Address");
			String eAddress = br.readLine();
			System.out.println("Enter customer Password");
			String pwd = br.readLine();

			Customer customer = new Customer();
			customer.setFirstName(fName);
			customer.setLastName(lName);
			customer.setAge(age);
			customer.setAddress(address);
			customer.setEmailAddress(eAddress);
			customer.setPassword(pwd);
			int result = customerService.addCustomer(customer);
			if (result > 0) {
				System.out.println(result + " Customer record saved sucessfully ");
			} 
			System.out.println(" Do you want to Add another Customer ? Y/N ");
			selection = br.readLine().charAt(0);
			}while (selection == 'Y' || selection == 'y');
			break;

		case 2:
			List<CustomerDto> customers = customerService.getAllCustomer();
			for (CustomerDto customer: customers) {
				System.out.println(customer);
			}
			break;

		case 3:
			System.out.println(" Enter id of a customer which you want to retrieve ");
			CustomerDto customer = customerService.getCustomerById(Integer.parseInt(br.readLine()));
			System.out.println(customer);
			break;

		case 4:
			System.out.println(" Enter id of a customer which password you want to update ");
			CustomerDto customerUpdate = customerService.updateCustomerById(Integer.parseInt(br.readLine()), br.readLine());
			System.out.println(customerUpdate);
			break;

		case 5:
			System.out.println(" Enter id of a customer which you want to delete ");
			int customerDelete = customerService.deleteCustomerById(Integer.parseInt(br.readLine()));
			if(customerDelete != 0) {
				System.out.println("Customer deleted Succesfully");
			}
			break;

		default:
			break;
			}
		System.out.println(" Do you want to continue other operations? Y/N ");
		 selection2 = br.readLine().charAt(0);
		 if(selection2 == 'n' || selection2== 'N') {
			 System.out.println(" Thank you for using customer manangement app ");
			 System.exit(0);
		 }
		}while (selection2== 'y'|| selection2== 'Y');
		
		
	}

}
