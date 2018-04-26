package com.me.Controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
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
	
//	@RequestMapping(value="addToCart", method=RequestMethod.POST)
//	protected ModelAndView addToCart(HttpServletRequest request, HttpServletResponse response) {
//		
//		int counter = 0;
//		
//	}
	
	
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
		
	@RequestMapping(value="actionOnProduct", method = RequestMethod.POST)
	public ModelAndView actionOnProduct(HttpServletRequest request, HttpServletResponse response,@RequestParam("id") Integer id,@RequestParam("pName") String name, @RequestParam("pType") String type,
     		@RequestParam("pPrice") Float price) throws Exception {
		
		System.out.println("I am inside action");
		ModelAndView mv = null;
		
		if(request.getParameter("update")!=null) {
		
		try {
			    
			    System.out.println("I am inside action edit");
		       	
			
		        System.out.println(price);
				Product p = new Product();
    
				p.setID(id);
				p.setpName(name);
				p.setpPrice(price);
				p.setpType(type);
		    
				Product p1 = productDao.updateProduct(p);
				System.out.println(p1.getpName());
				
				List<Product> productList = productDao.list();
				mv = new ModelAndView("editProducts", "productList", productList);	   
					return mv;	
	  		}
	 catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
			   mv = new ModelAndView("signUpErr", "errorMessage", "error while login");
			   return mv;	
		      
	  }
		}else if(request.getParameter("delete")!=null){
			
			try {
				System.out.println("In delete product method");

			    Product p = new Product();
			    p.setID(id);
			    p.setpName(name);
			    p.setpPrice(price);
			    p.setpType(type);
			    
				boolean isDeleted = productDao.deleteProduct(p);
				if (isDeleted) {
					List<Product> productList = productDao.list();
					 mv = new ModelAndView("editProducts", "productList", productList);	   
						return mv;				

				} else {
					mv = new ModelAndView("signUpErr", "errorMessage", "error while login");
					return mv;	
				}			
		
				 
		}	catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
			return new ModelAndView("signUpErr", "errorMessage", "error while login");
			}
		}
		else {
			
		}
		return mv;
	

		}
	
	@RequestMapping(value="editProduct", method = RequestMethod.POST)
	public ModelAndView sendProductPage(HttpServletRequest request, HttpServletResponse response, @RequestParam("PID") String id,
			@RequestParam("PName") String name, @RequestParam("PType") String type,
     		@RequestParam("PPrice") String price) throws Exception{		
		try {
				System.out.println("In edit product method");
	
				ModelAndView mv = new ModelAndView();
				int productID = Integer.parseInt(id);
				Float pPrice = Float.parseFloat(price);
		
				Product p = new Product();
    
				p.setID(productID);
				p.setpName(name);
				p.setpPrice(pPrice);
				p.setpType(type);
		    
				Product p1 = productDao.updateProduct(p);
				System.out.println(p1.getpName());
				
				List<Product> productList = productDao.list();
				 mv = new ModelAndView("editProducts", "productList", productList);	   
				
				 return mv;
				 
		}	catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
			return new ModelAndView("signUpErr", "errorMessage", "error while login");
			}
		}		
}
	
//
//	@RequestMapping(value="deleteProduct", method = RequestMethod.POST)
//	public ModelAndView deleteProductPage(HttpServletRequest request, HttpServletResponse response, @RequestParam("PID") String id,
//		@RequestParam("PName") String name, @RequestParam("PType") String type,
// 		@RequestParam("PPrice") String price) throws Exception{		
//	try {
//			System.out.println("In delete product method");
//
//			ModelAndView mv = new ModelAndView();
//			boolean isDeleted = productDao.deleteProduct(Integer.parseInt("id"));
//			if (isDeleted) {
//				List<Product> productList = productDao.list();
//				 mv = new ModelAndView("editProducts", "productList", productList);	   
//				
//				 return mv;
//
//			} else {
//				return new ModelAndView("signUpErr", "errorMessage", "error while login");
//			}			
//	
//			 
//	}	catch (Exception e) {
//		System.out.println("Exception: " + e.getMessage());
//		return new ModelAndView("signUpErr", "errorMessage", "error while login");
//		}
//	}		
//
//}
//		

	
//	@RequestMapping(value = "enterEditProduct", method = RequestMethod.POST)
//	public ModelAndView enterEditProduct(HttpServletRequest request, HttpServletResponse response, @RequestParam("PID") String id,
//			@RequestParam("PName") String name, @RequestParam("PType") String type,
//			@RequestParam("PPrice") String price
//			) throws Exception {
//	    
//		try {
//		System.out.println("In edit product method");
//		
//		ModelAndView mv = new ModelAndView();
//		int productID = Integer.parseInt(id);
//	    Float pPrice = Float.parseFloat(price);
//		
//	    Product p = new Product();
//	    
//	    p.setID(productID);
//	    p.setpName(name);
//	    p.setpPrice(pPrice);
//	    p.setpType(type);
//	    
//	    Product p1 = productDao.updateProduct(p);
//	    System.out.println(p1.getpName());
//	    
//	    List<Product> productList = productDao.list();
//		return new ModelAndView("editProducts", "productList", productList);	   
//	 
//		}	catch (Exception e) {
//			System.out.println("Exception: " + e.getMessage());
//			return new ModelAndView("signUpErr", "errorMessage", "error while login");
//		}
//	}		
// 	}

