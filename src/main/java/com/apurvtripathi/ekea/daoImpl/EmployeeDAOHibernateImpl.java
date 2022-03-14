package com.apurvtripathi.ekea.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.apurvtripathi.ekea.dao.EmployeeDAO;
import com.apurvtripathi.ekea.entity.Employee;
@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<Employee> findAll() {
		//get the current hibernate session
		Session currentSession=entityManager.unwrap(Session.class);
		//create a query to get all the employees
		Query<Employee> theQuery=currentSession.createQuery("from Employee", Employee.class);
		// create a list of all the employees
		List<Employee> employees=theQuery.getResultList();
		//return the list of employees
		return employees;
	}

	@Override
	public Employee findById(int id) {
		//get the current hibernate session
		Session currentSession=entityManager.unwrap(Session.class);
		
		Employee theEmployee=currentSession.get(Employee.class, id);
		
		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {
		//get the current hibernate session
		Session currentSession=entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(theEmployee);
		
		
	}

	@Override
	public void deleteById(int theId) {
		//get the current hibernate session
		Session currentSession=entityManager.unwrap(Session.class);
		Query theQuery=currentSession.createQuery("delete from Employee where id=:employeeId");
		theQuery.setParameter("employeeId", theId);
		theQuery.executeUpdate();
		
		
	}



}
