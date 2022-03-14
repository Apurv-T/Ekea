package com.apurvtripathi.ekea.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apurvtripathi.ekea.dao.ProductDAO;
import com.apurvtripathi.ekea.entity.Product;
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDAO theProductDAO;
	
	@Override
	public List<Product> findAll() {
		return theProductDAO.findAll();
	}

	@Override
	public Product findById(int id) {
		
		return theProductDAO.findById(id);
	}

	@Override
	public void save(Product theProduct) {
		theProductDAO.save(theProduct);
		
	}

	@Override
	public void deleteById(int theId) {
		theProductDAO.deleteById(theId);
		
	}

}
