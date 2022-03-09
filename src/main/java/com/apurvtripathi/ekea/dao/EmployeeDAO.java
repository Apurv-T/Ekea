package com.apurvtripathi.ekea.dao;

import java.util.List;

import com.apurvtripathi.ekea.entity.Employee;

//Data Access Model for Employee

public interface EmployeeDAO {
	
	public List<Employee> findAll();
	public Employee findById(int id);
	public void save(Employee theEmployee);
	public void deleteById(int theId);
}
