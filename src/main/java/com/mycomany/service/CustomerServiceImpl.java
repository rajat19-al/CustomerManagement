package com.mycomany.service;

import java.util.List;

import com.mycomany.model.Customer;
import com.mycompany.dao.CustomerDao;
import com.mycompany.dao.CustomerDaoImpl;
import com.mycompany.dto.CustomerDto;

public class CustomerServiceImpl implements CustomerService {
	private CustomerDao customerDao = new CustomerDaoImpl();

	public int addCustomer(Customer customer) {
		
		return customerDao.add(customer);
		
	}

	public List<CustomerDto> getAllCustomer() {
		
		return customerDao.getAllCustomers();
	}

	public CustomerDto getCustomerById(int id) {
		
		return customerDao.getCustomerById(id);
	}

	public CustomerDto updateCustomerById(int id, String password) {
		
		return customerDao.update(id, password);
	}

	public int deleteCustomerById(int id) {
		
		return customerDao.delete(id);
	}

}
