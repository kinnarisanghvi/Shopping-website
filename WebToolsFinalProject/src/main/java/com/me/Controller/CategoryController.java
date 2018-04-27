package com.me.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.me.DAO.CategoryDao;
import com.me.Pojo.Category;
import com.me.Pojo.Product;

@Controller
public class CategoryController {

	@Autowired
	@Qualifier("categoryDao")
	CategoryDao categoryDao;
	
	@RequestMapping(value="addCategory", method=RequestMethod.GET)
	protected ModelAndView productForm(HttpServletRequest request, HttpServletResponse response)throws Exception{
		
		ModelAndView mv = new ModelAndView();
    	mv.setViewName("addCategory");
    	
    	return mv;	
		
	}
	
	@RequestMapping(value="addCategory", method=RequestMethod.POST)
	protected ModelAndView addProduct(HttpServletRequest request,  HttpServletResponse response,
			@RequestParam("name") String name)throws Exception{
		
		try {

			List<Category> categoryList;
				
			
			System.out.print("addingCategory");

			Category c = new Category();
			c.setCategoryName(name);
		  
					
			System.out.println("adding category in dao");
			categoryDao.addCategory(c);
			 
			System.out.println("sending category to view");
			
			return new ModelAndView("SuccessProduct");

		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
			return new ModelAndView("signUpErr", "errorMessage", "error while login");
		}
			
	}

}
