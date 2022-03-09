package com.apurvtripathi.ekea.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apurvtripathi.ekea.dao.EmployeeDAO;
import com.apurvtripathi.ekea.entity.Employee;
@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeDAO theEmployeeDAO;
	
	@Override
	@Transactional
	public List<Employee> findAll() {
		return theEmployeeDAO.findAll();
	}

	@Override
	@Transactional
	public Employee findById(int id) {
		return theEmployeeDAO.findById(id);
	}

	@Override
	@Transactional
	public void save(Employee theEmployee) {
		theEmployeeDAO.save(theEmployee);
		
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		theEmployeeDAO.deleteById(theId);
		
	}

}
