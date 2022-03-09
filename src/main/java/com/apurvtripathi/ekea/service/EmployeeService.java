package com.apurvtripathi.ekea.service;
import java.util.List;

import com.apurvtripathi.ekea.entity.Employee;

public interface EmployeeService {
	
	public List<Employee> findAll();
	public Employee findById(int id);
	public void save(Employee theEmployee);
	public void deleteById(int theId);

}
