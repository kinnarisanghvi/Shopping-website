package com.me.Controller;


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
import com.me.DAO.UserDao;
import com.me.Pojo.Product;
import com.me.Pojo.Users;

@Controller
public class MainController{
	
	@Autowired
	@Qualifier("productDao")
	ProductDao productDao;
	
	@Autowired
	@Qualifier("userDao")
	UserDao userDao;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
    protected ModelAndView firstPage() {
    	
    	ModelAndView mv = new ModelAndView();
    	mv.setViewName("admin");
    	
    	return mv;
	}
	
	@RequestMapping(value="login", method=RequestMethod.GET)
	protected ModelAndView login(HttpServletRequest request, HttpServletResponse response)throws Exception{
		
		ModelAndView mv = new ModelAndView();
    	mv.setViewName("Login");
    	
    	return mv;	
		
	}
	
	@RequestMapping(value="signUp", method=RequestMethod.GET)
	protected ModelAndView signUp(HttpServletRequest request, HttpServletResponse response)throws Exception{
		
		ModelAndView mv = new ModelAndView();
    	mv.setViewName("signUp");
    	
    	return mv;	
		
	}
	
	
	@RequestMapping(value="login", method=RequestMethod.POST)
	protected ModelAndView login(HttpServletRequest request, @RequestParam("username") String username, @RequestParam("password") String password,
		@RequestParam("role") String role)
	throws Exception{
		
			
			System.out.println("login user");
			
			Users u = userDao.getUser(username,password,role);
			ModelAndView mv = null;
			
			if(u == null){
				System.out.println("UserName/Password does not exist");
				HttpSession session = request.getSession();
				session.setAttribute("errorMessage", "UserName/Password does not exist");
				mv =  new ModelAndView("Login");
			}
			
			else if(u.getRole().equals("admin")) {
				System.out.println("In admin condition");
				mv = new ModelAndView("productManage");
				System.out.println("After setting mv for admin");
			}
			
			else if(u.getRole().equals("customer")){
				
				System.out.println("In customer condition");
				
				request.getSession().setAttribute("user", u);
				System.out.println("After adding products for user");
				List<Product> productList = productDao.list();
				mv = new ModelAndView("userPage", "productList", productList);
			}
			return mv;
			
		}

	
	@RequestMapping(value="signUp", method=RequestMethod.POST)
	protected ModelAndView registerNewUser(HttpServletRequest request,@RequestParam("firstName") String fn,
			@RequestParam("lastName") String ln,
			@RequestParam("role") String role,
			@RequestParam("phone") String phone,
			@RequestParam("address") String address,
			@RequestParam("password") String password,
			@RequestParam("username") String username 
			) throws Exception {


		try {

			System.out.print("registerNewUser");

			Users u = new Users();
			
			u.setFirstName(fn);
			u.setLastName(ln);
			u.setUsername(username);
			u.setPassword(password);
			u.setRole(role);
			
			System.out.println("adding user in dao");
			userDao.addUser(u);
			
			return new ModelAndView("successSignup");

		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
			return new ModelAndView("signUpErr", "errorMessage", "error while login");
		}
	}

	
}