package com.apurvtripathi.ekea.daoImpl;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.apurvtripathi.ekea.dao.CustomerDAO;
import com.apurvtripathi.ekea.entity.Customer;
@Repository
public class CustomerDAOHibernateImpl implements CustomerDAO {
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public void add(Customer customer) {
		Session currentSession=entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(customer);
		
	}

	@Override
	public Customer getCustomer(int id) {
		Session currentSession=entityManager.unwrap(Session.class);
		Customer theCustomer=currentSession.get(Customer.class, id);
		if(theCustomer==null) {
			return null;
		}
		return theCustomer;
	}
	

}
