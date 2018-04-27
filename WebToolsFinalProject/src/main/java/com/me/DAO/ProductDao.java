package com.me.DAO;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.me.Pojo.Product;

public class ProductDao extends Dao {

	public void addProduct(Product p)
			throws Exception {
		try {
			begin();
			System.out.println("inside ProductDAO");
			
			getSession().save(p);
			commit();	
		} catch (Exception e) {
			rollback();
			throw new Exception("Exception while adding product: " + e.getMessage());
		}
	}
	
		public List<Product> list() throws Exception{
    	
    	try {
            begin();
            Query q = getSession().createQuery("from Product");
            @SuppressWarnings("unchecked")
			List<Product> products = q.list();
            commit();
            return products;
        } catch (HibernateException e) {
            rollback();
            throw new Exception("Could not get products", e);
        }
    	
    }
		
		public Product getProduct(int productID)throws Exception{
			
			  try {
		        	
		        	begin();
		        	Query q = getSession().createQuery("from Product where ProductID = :productID");
		        	q.setInteger("productID", productID);
					Product p = (Product) q.uniqueResult();
					System.out.println("Going to retreive product");
		            
					System.out.println(p.getID());
		            commit();
		            System.out.println("Returning product after retreiving");
		            return p;
		        } catch (HibernateException e) {
		            rollback();
		            throw new Exception("Could not retrieve the product", e);
		        }
		    }

		
		
		 public Product updateProduct(Product p) throws Exception {
			 try {
		            begin();
		            getSession().update(p);
		            commit();
		            System.out.println("After updating product in productDao");
		            return p;
		        } catch (HibernateException e) {
		            rollback();
		            throw new Exception("Could not update the product", e);
		        }
			 
		    }
		 
		 public boolean deleteProduct(Product p) {
			 
			 System.out.println("In delete productdao method");

				
			
				try {
					begin();
					getSession().delete(p);
					commit();
					System.out.println("In delete commit");
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
