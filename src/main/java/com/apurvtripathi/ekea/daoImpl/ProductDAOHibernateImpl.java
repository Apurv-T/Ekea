package com.apurvtripathi.ekea.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.apurvtripathi.ekea.dao.ProductDAO;
import com.apurvtripathi.ekea.entity.Product;
@Repository
public class ProductDAOHibernateImpl implements ProductDAO{
	

	private EntityManager entityManager;
	
	@Autowired
	public ProductDAOHibernateImpl(EntityManager entityManager) {
		this.entityManager=entityManager;
	}

	@Override
	public List<Product> findAll() {
		//get the current hibernate session
		Session currentSession=entityManager.unwrap(Session.class);
		//create a query to get all the Products
		Query<Product> theQuery=currentSession.createQuery("from Product", Product.class);
		// create a list of all the Products
		List<Product> products=theQuery.getResultList();
		//return the list of Products
		return products;
	}

	@Override
	public Product findById(int id) {
		//get the current hibernate session
		Session currentSession=entityManager.unwrap(Session.class); 
		Product theProduct=currentSession.get(Product.class, id);
		return theProduct;
	}

	@Override
	public void save(Product theProduct) {
		//get the current hibernate session
		Session currentSession=entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(theProduct);
	}

	@Override
	public void deleteById(int theId) {
		//get the current hibernate session
		Session currentSession=entityManager.unwrap(Session.class);
		Query<Product> theQuery=currentSession.createQuery("delete from Product where id:=ProductId", Product.class);
		theQuery.setParameter("ProductId", theId);
		theQuery.executeUpdate();
		
	}

}
