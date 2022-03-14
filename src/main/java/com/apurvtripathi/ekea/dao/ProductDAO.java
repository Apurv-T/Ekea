package com.apurvtripathi.ekea.dao;

import java.util.List;
import com.apurvtripathi.ekea.entity.Product;

public interface ProductDAO {
	
	public List<Product> findAll();
	public Product findById(int id);
	public void save(Product theProduct);
	public void deleteById(int theId);
}
