package com.apurvtripathi.ekea.rest;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.apurvtripathi.ekea.entity.Cart;
import com.apurvtripathi.ekea.entity.Customer;
import com.apurvtripathi.ekea.entity.Product;
import com.apurvtripathi.ekea.service.CustomerService;
import com.apurvtripathi.ekea.service.ProductService;

@Controller

public class homeController implements ErrorController{
	@Autowired
	private ProductService theProductService;
	
	@Autowired
	private CustomerService theCustomerService;
	private Cart theCart;
	@RequestMapping("/")
	public String getHomePage(Model theModel, HttpServletRequest request) {
		if(this.theCart==null) {
			this.theCart=new Cart();
		}
		userMemebership(theModel, request);
		int cartCount=0;
		if(this.theCart.getProducts()!=null)
		{
			cartCount=this.theCart.getProducts().size();
		}
		theModel.addAttribute("cartProductCount", cartCount);
		theModel.addAttribute("productList", theProductService.findAll());
		return "index";
	}
	
	@ConditionalOnMissingBean
	@RequestMapping("/error")
	public String error(Model theModel, HttpServletRequest request) {
		int cartCount=0;
		if(this.theCart.getProducts()!=null)
		{
			cartCount=this.theCart.getProducts().size();
		}
		userMemebership(theModel, request);
		theModel.addAttribute("cartProductCount", cartCount);
		return "error";
	}
	
	@RequestMapping("/signup")
	public String getSignUpForm(Model theModel, HttpServletRequest request) {
		
		userMemebership(theModel, request);
		if(theModel.containsAttribute("username")) {
			return "redirect:/";
		}
		Customer theCustomer=new Customer();
		theModel.addAttribute("customer",theCustomer);
		return "signupForm";
	}
	
	@RequestMapping("/login")
	public String getLogInForm(Model theModel, HttpServletRequest request) {
		userMemebership(theModel, request);
		return "loginForm";
	}
	
	@RequestMapping("/about")
	public String getAboutPage(Model theModel, HttpServletRequest request) {
		userMemebership(theModel, request);
		return "about";
	}

	@PostMapping("/signupSuccess")
	public String getHomePage(@ModelAttribute("customer") Customer theCustomer, HttpServletResponse response, Model theModel) {
		Cookie theCookie=new Cookie("username",theCustomer.getFirstName());
		response.addCookie(theCookie);
		theCustomerService.add(theCustomer);
		return "redirect:/";
	}
	
	@RequestMapping("/productAdded{productId}")
	public String getCartPage(@RequestParam(value="productId") int theId,   Model theModel, HttpServletRequest request) {
		if(this.theCart==null) {
			this.theCart=new Cart();
		}
		Product theProduct=this.theProductService.findById(theId);
		System.out.println(theProduct);
		userMemebership(theModel, request);
		this.theCart.addProduct(theProduct);

		
		return "redirect:/";
	}
	
	@RequestMapping("/addToCart")
	public String getCartPage( Model theModel, HttpServletRequest request) {
		if(this.theCart==null) {
			this.theCart=new Cart();
		}
		userMemebership(theModel, request);
		int subTotal=0;
		if(theCart.getProducts()!=null) {
			for(Product tempProduct:theCart.getProducts()) {
				subTotal+=tempProduct.getPrice();
			}
		}
		theModel.addAttribute("cartTotal", subTotal);
		theModel.addAttribute("cart", theCart.getProducts());
		
		
		return "productCart";
	}
	
	@RequestMapping("/removeFromCart{elementId}")
	public String removeFromCart(@RequestParam(value="elementId") int theId,   Model theModel, HttpServletRequest request) {

		Product theProduct=this.theProductService.findById(theId);
	
		userMemebership(theModel, request);
		this.theCart.removeProduct(theId);
		int subTotal=0;
		if(theCart.getProducts()!=null) {
			for(Product tempProduct:theCart.getProducts()) {
				subTotal+=tempProduct.getPrice();
			}
		}
		theModel.addAttribute("cartTotal", subTotal);
		theModel.addAttribute("cart", theCart.getProducts());
		
		return "productCart";
	}
	

	private void userMemebership(Model theModel, HttpServletRequest request) {
		Cookie[] cookies=request.getCookies();
		if(cookies!=null) {
			for(Cookie theCookie:cookies) {
				if(theCookie.getName().equals("username")) {
					theModel.addAttribute("username", theCookie.getValue());	
				}	
			}
		}
		
	}
	

}


