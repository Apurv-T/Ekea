package com.apurvtripathi.ekea.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.apurvtripathi.ekea.service.ProductService;

@Controller
@RequestMapping("/api")
public class ProductController {
	
	private ProductService theProductService;
	
	@Autowired
	public ProductController(ProductService theProductService) {
		this.theProductService=theProductService;
	}
	
	
	@RequestMapping("/products")
	public String getProductList(Model theModel) {
		theModel.addAttribute("productList", theProductService.findAll());
		return "productList";
	}
	
	

}
