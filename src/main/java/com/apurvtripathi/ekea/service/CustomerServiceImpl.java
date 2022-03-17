package com.apurvtripathi.ekea.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apurvtripathi.ekea.dao.CustomerDAO;
import com.apurvtripathi.ekea.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired()
	private CustomerDAO theCustomerDAO;
	
	@Override
	public void add(Customer theCustomer) {
		theCustomerDAO.add(theCustomer);	
	}
	@Override
	public Customer getCustomer(int id) {
		return theCustomerDAO.getCustomer(id);
	}

}
