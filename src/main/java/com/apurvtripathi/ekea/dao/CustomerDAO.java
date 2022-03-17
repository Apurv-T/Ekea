package com.apurvtripathi.ekea.dao;

import com.apurvtripathi.ekea.entity.Customer;

public interface CustomerDAO {

	public void add(Customer customer);
	
	public Customer getCustomer(int id);
}
