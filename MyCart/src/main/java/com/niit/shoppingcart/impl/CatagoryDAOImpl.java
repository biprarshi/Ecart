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

import com.niit.shoppingcart.dao.CatagoryDAO;

/**
 * @author Jo
 *
 */ 

import com.niit.shoppingcart.model.Catagory;
import com.niit.shoppingcart.model.Product;

@Repository("catagoryDAO")
@Transactional
public class CatagoryDAOImpl implements CatagoryDAO{
	@Autowired
	private SessionFactory sessionFactory;
	
	
	
	/**
	 * @param sessionFactory the sessionFactory to set
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	protected Session getSession(){
		
		return sessionFactory.openSession();
	}
	
	public List<Catagory> list(){
		Session session=getSession();
		
		Query query =session.createQuery("from Catagory");
		List <Catagory> catagoryList=query.list();
		session.close();
		return catagoryList;
	}

	public Catagory listByCatagoryId(int catagoryId) {
	// TODO Auto-generated method stub
		Session session=getSession();
	

	Query query =session.createQuery("from Catagory where productCatagory.catagoryId = :catagoryId ");  // HQL
	
	query.setParameter("catagoryId", catagoryId);
	List <Catagory> catagoryList=query.list();
	session.close();
	
	if (catagoryList ==null || catagoryList.isEmpty())
	{
		return null;
	}
	else
	{
		return catagoryList.get(0);
	}
	
	
}

	
}
