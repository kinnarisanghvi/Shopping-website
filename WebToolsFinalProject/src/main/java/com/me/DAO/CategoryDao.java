package com.me.DAO;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.me.Pojo.Category;
import com.me.Pojo.Product;


public class CategoryDao extends Dao{

	
	
	public void addCategory(Category c)
			throws Exception {
		try {
			begin();
			System.out.println("inside CategoryDAO");
			
			getSession().save(c);
			commit();	
		} catch (Exception e) {
			rollback();
			throw new Exception("Exception while adding category: " + e.getMessage());
		}
	}
	
	public List<Category> list() throws Exception{
    	
    	try {
            begin();
            Query q = getSession().createQuery("from Category");
			List<Category> categoryList =  q.list();
            commit();
            return categoryList;
        } catch (HibernateException e) {
            rollback();
            throw new Exception("Could not get category", e);
        }
    	
    }
	
	public Category getCategory(int categoryID)throws Exception{
		
		  try {
	        	
	        	begin();
	        	Query q = getSession().createQuery("from Category where ID = :categoryID");
	        	q.setInteger("categoryID", categoryID);
				Category c = (Category) q.uniqueResult();
				System.out.println("Going to retreive category");
	            
				System.out.println(c.getID());
	            commit();
	            System.out.println("Returning category after retreiving");
	            return c;
	        } catch (HibernateException e) {
	            rollback();
	            throw new Exception("Could not retrieve the category", e);
	        }
	    }
	
	 public boolean deleteCategory(Category c) {
		 
		 System.out.println("In delete categorydao method");
		
			try {
				begin();
				getSession().delete(c);
				commit();
				System.out.println("In delete category commit");
				return true;
			} 
			catch (HibernateException e) {
				rollback();
				e.printStackTrace();
			} finally {
				close();
			}
			return false;
		}



}
