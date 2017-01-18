/**
 * 
 */
package com.niit.shoppingcart.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.model.Catagory;
import com.niit.shoppingcart.model.User;

/**
 * @author Jo
 *
 */
@Repository("UserDAO")
@Transactional
public class UserDAOImpl implements UserDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	protected Session getSession(){
		
		return sessionFactory.openSession();
	}
	
	public List<User> list(){
		Session session=getSession();
		
		Query query =session.createQuery("from User");
		List <User> userList=query.list();
		session.close();
		return userList;
	}

}
