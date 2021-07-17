package com.mycompany.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mycomany.dbutil.DbUtil;
import com.mycomany.model.Customer;
import com.mycompany.dto.CustomerDto;

public class CustomerDaoImpl implements CustomerDao {

	private Connection con = DbUtil.createConnection();
	private PreparedStatement ps = null;
	private ResultSet rs = null; 
//	private static int x = 100;
	
	public int add(Customer customer) {
		int record =0;
		try {
			ps = con.prepareStatement("INSERT INTO CUSTOMER(firstName, lastName, age, Address, emailAddress, password) VALUES(?,?,?,?,?,?)");
			ps.setString(1, customer.getFirstName());
			ps.setString(2, customer.getLastName());
			ps.setInt(3, customer.getAge());
			ps.setString(4, customer.getAddress());
			ps.setString(5, customer.getEmailAddress());
			ps.setString(6, customer.getPassword());
			record = ps.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return record;
	}

	public List<CustomerDto> getAllCustomers() {
		List<CustomerDto> customers = new ArrayList<CustomerDto>();
		try {
			ps = con.prepareStatement("Select * from Customer");
			rs = ps.executeQuery();
			while(rs.next()) {
				int id = rs.getInt(1);
				String fname = rs.getString(2);
				String lname = rs.getString(3);
				int age = rs.getInt(4);
				String address = rs.getString(5);
				String eaddress = rs.getString(6);
//				String pwd = rs.getString(7);
				
				CustomerDto customer = new CustomerDto();
//				customer.setId(id);
				customer.setFirstName(fname);
				customer.setLastName(lname);
//				customer.setAge(age);
//				customer.setAddress(address);
				customer.setEmailAddress(eaddress);
//				customer.setPassword(pwd);
				customers.add(customer);
				}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customers;
	}

	public CustomerDto getCustomerById(Integer id) {
		CustomerDto customer = null;
		try {
			ps = con.prepareStatement("Select firstName, lastName, emailAddress from Customer where id=?");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			 while(rs.next()) {
					String fname = rs.getString(1);
					String lname = rs.getString(2);
					String eaddress = rs.getString(3);
					
					customer = new CustomerDto();
//					customer.setId(id);
					customer.setFirstName(fname);
					customer.setLastName(lname);
//					customer.setAge(age);
//					customer.setAddress(address);
					customer.setEmailAddress(eaddress);
//					customer.setPassword(pwd);
//					customers.add(customer);
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customer;
	}
	
	
	public CustomerDto update(Integer id, String password) {
		CustomerDto customer = null;	
		Customer updateId = new Customer();
			int updateResult = 0;
			try{
				ps = con.prepareStatement("Update customer SET password= ? WHERE ID =?");
				ps.setString(1, password);
				ps.setInt(2, id);
				updateResult = ps.executeUpdate();
				
				if(updateResult != 0) {
					ps = con.prepareStatement("select firstName, lastName, emailAddress, password from Customer where id = ?");
					ps.setInt(1, id);
					rs = ps.executeQuery();
					 while(rs.next()) {
							String fname = rs.getString(1);
							String lname = rs.getString(2);
							String eaddress = rs.getString(3);
							String pwd = rs.getString(4);
							
							customer = new CustomerDto();
//							customer.setId(id);
							customer.setFirstName(fname);
							customer.setLastName(lname);
//							customer.setAge(age);
//							customer.setAddress(address);
							customer.setEmailAddress(eaddress);
							customer.setPassword(pwd);
//							customers.add(customer);
					 }
				}
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return customer;
	}
	
	public int delete(Integer id) {
		int deleteId = 0;
		try{
			ps = con.prepareStatement("DELETE FROM customer WHERE ID = ?");
			ps.setInt(1, id);
			deleteId = ps.executeUpdate();
		}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return deleteId;
	}



}
