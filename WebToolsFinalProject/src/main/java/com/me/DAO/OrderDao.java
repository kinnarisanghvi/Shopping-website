package com.me.DAO;

import com.me.Pojo.Order;

public class OrderDao extends Dao{

	public void addOrder(Order o)
			throws Exception {
		try {
			begin();
			System.out.println("inside OrderDAO");
			
			getSession().save(o);
			commit();
			

		} catch (Exception e) {
			rollback();
			throw new Exception("Exception while adding order: " + e.getMessage());
		}
	}
}

