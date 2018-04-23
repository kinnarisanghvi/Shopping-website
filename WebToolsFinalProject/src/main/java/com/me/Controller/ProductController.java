package com.me.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.me.DAO.ProductDao;
import com.me.Pojo.Product;


@Controller
public class ProductController {

	@Autowired
	@Qualifier("productDao")
	ProductDao productDao;
	
	@RequestMapping(value="addProduct", method=RequestMethod.GET)
	protected ModelAndView productForm(HttpServletRequest request, HttpServletResponse response)throws Exception{
		
		ModelAndView mv = new ModelAndView();
    	mv.setViewName("addProduct");
    	
    	return mv;	
		
	}
	
	@RequestMapping(value="addProduct", method=RequestMethod.POST)
	protected ModelAndView addProduct(HttpServletRequest request,  HttpServletResponse response,
			@RequestParam("ID") String id, @RequestParam("name") String name,
			@RequestParam("type") String type, @RequestParam("price") String price
			)throws Exception{
		
		try {

			System.out.print("addingProduct");

			Product p = new Product();
			p.setID(Integer.parseInt(id));
			p.setpName(name);
			p.setpPrice(Float.parseFloat(price));
			p.setpType(type);
			
			System.out.println("adding product in dao");
			productDao.addProduct(p);
			 
			System.out.println("sending product to view");
			
			return new ModelAndView("SuccessProduct");

		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
			return new ModelAndView("signUpErr", "errorMessage", "error while login");
		}
			
	}
	
	

	@RequestMapping(value = "manageProducts", method = RequestMethod.GET)
		public ModelAndView manageProduct(HttpServletRequest request, HttpServletResponse response) throws Exception {
		    
			try {
				
				List<Product> productList = productDao.list();
				return new ModelAndView("editProducts", "productList", productList);
			}	catch (Exception e) {
				System.out.println("Exception: " + e.getMessage());
				return new ModelAndView("signUpErr", "errorMessage", "error while login");
			}
		}
		
	
	@RequestMapping(value="editProduct", method = RequestMethod.GET)
	public ModelAndView sendProductPage(HttpServletRequest request,  HttpServletResponse response, @RequestParam("id") String id) throws Exception{
		
		int productID = Integer.parseInt(request.getParameter("id"));
		
		
		Product p = productDao.getProduct(productID);
		
		HttpSession session= request.getSession();
		session.setAttribute("product",p);
		
		return new ModelAndView("EnterEditProduct");
	}
		

	
	@RequestMapping(value = "enterEditProduct", method = RequestMethod.POST)
	public ModelAndView enterEditProduct(HttpServletRequest request, HttpServletResponse response, @RequestParam("PID") String id,
			@RequestParam("PName") String name, @RequestParam("PType") String type,
			@RequestParam("PPrice") String price
			) throws Exception {
	    
		try {
		System.out.println("In edit product method");
		int productID = Integer.parseInt(request.getParameter("id"));
	    Float pPrice = Float.parseFloat("PPrice");
		
	    Product p = new Product();
	    
	    p.setID(productID);
	    p.setpName(name);
	    p.setpPrice(pPrice);
	    p.setpType(type);
	    
	    Product p1 = productDao.updateProduct(p);
	    
	    
	    return new ModelAndView("productupdated");
	 
		}	catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
			return new ModelAndView("signUpErr", "errorMessage", "error while login");
		}
	}		
 	}

