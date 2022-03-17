package com.apurvtripathi.ekea.service;

import com.apurvtripathi.ekea.entity.Customer;

public interface CustomerService {

	public void add(Customer theCustomer);
	public Customer getCustomer(int id);
}
