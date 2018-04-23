package com.me.DAO;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.me.Pojo.Users;

public class UserDao extends Dao  {

	public void addUser(Users u)
			throws Exception {
		try {
			begin();
			System.out.println("inside DAO");
			
			getSession().save(u);
			commit();
			

		} catch (Exception e) {
			rollback();
			throw new Exception("Exception while adding user: " + e.getMessage());
		}
	}
	
	public Users getUser(String u, String p, String role)
			throws Exception { {
				try{begin();
				Query q = getSession().createQuery("from Users where UserName = :username and Password = :password and Role = :role");
				System.out.println("Executed query");
				q.setString("username", u);
				q.setString("password", p);	
				q.setString("role", role);
				Users user = (Users) q.uniqueResult();
				commit();
				return user;
			} catch (HibernateException e) {
				rollback();
				throw new Exception("Could not get user " + u, e);
			}
		}

		}
}


