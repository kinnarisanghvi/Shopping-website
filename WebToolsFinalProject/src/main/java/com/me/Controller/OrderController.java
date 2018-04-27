package com.me.Controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import javax.persistence.criteria.Expression;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.me.DAO.CategoryDao;
import com.me.DAO.OrderDao;
import com.me.DAO.UserDao;
import com.me.Pojo.Product;
import com.me.Pojo.Users;
import com.me.Pojo.Order;

@Controller

public class OrderController {

	@Autowired
	@Qualifier("userDao")
	UserDao userDao;
	
	@Autowired
	@Qualifier("categoryDao")
	CategoryDao categoryDao;
	
	@Autowired
	@Qualifier("orderDao")
	OrderDao orderDao;
	
	@RequestMapping(value="addToCart", method=RequestMethod.GET)
    protected ModelAndView firstPage(HttpServletRequest request, HttpServletResponse response, @RequestParam("prodID") String prodID, @RequestParam("prodName") String name) throws Exception {
    	
		HttpSession session = (HttpSession) request.getSession();
	    ModelAndView mv = new ModelAndView();
    	
	    Users user = (Users) session.getAttribute("user");
	    if(prodID!=null) {
	    	
	    
	    	System.out.println("userid for order : "+ user.getUsername());
	    	
	    	Order order = new Order();
	    	DateFormat dateFomt = new SimpleDateFormat("MM/dd/yyyy");
    		Date date = new Date();
            order.setDate(dateFomt.format(date));
            order.setUser(user);
            order.setProdQuantity(1);
            order.setProdName(name);
            orderDao.addOrder(order); 
            System.out.println("Returning from dao");	
		    mv.setViewName("Order added");
	      
  }
		return mv;
}}
