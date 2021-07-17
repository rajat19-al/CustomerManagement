package com.mycompany.dao;

import java.util.List;

import com.mycomany.model.Customer;
import com.mycompany.dto.CustomerDto;

public interface CustomerDao {

	public abstract int add(Customer customer);
	public abstract int delete(Integer id);
	public abstract CustomerDto update(Integer id, String password);
	public abstract List<CustomerDto> getAllCustomers();
	public abstract CustomerDto getCustomerById(Integer id);

		
}
