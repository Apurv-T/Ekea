package com.apurvtripathi.ekea.service;

import java.util.List;
import com.apurvtripathi.ekea.entity.Product;

public interface ProductService {

	public List<Product> findAll();
	public Product findById(int id);
	public void save(Product theProduct);
	public void deleteById(int theId);

}
