package com.mycomany.service;

import java.util.List;

import com.mycomany.model.Customer;
import com.mycompany.dto.CustomerDto;

public interface CustomerService {

	public abstract int addCustomer(Customer customer);
	public abstract List<CustomerDto> getAllCustomer();
	public abstract CustomerDto getCustomerById(int id);
	public abstract CustomerDto updateCustomerById (int id, String password);
	public abstract int deleteCustomerById (int id);
	
	
}
