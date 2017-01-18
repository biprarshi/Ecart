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

import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.model.Catagory;
import com.niit.shoppingcart.model.Product;

/**
 * @author Jo
 *
 */
@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO{
	@Autowired
	
	private SessionFactory sessionFactory;
	
	
	/**
	 * @return the sessionFactory
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * @param sessionFactory the sessionFactory to set
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	protected Session getSession(){
		
		return sessionFactory.openSession();
	}
	
	public List<Product> list(){
		Session session=getSession();
		
		Query query =session.createQuery("from Product");
		List <Product> productList=query.list();
		session.close();
		return productList;
	}

	/*public List<Product> listByCatagoryId(int productId) {
		// TODO Auto-generated method stub
Session session=getSession();
		

		Query query =session.createQuery("from Product where productCatagory.catagoryId = :catagoryId ");  // HQL
		
		query.setParameter("catagoryId", catagoryId);
		List <Product> productList=query.list();
		session.close();
		return productList;
	}*/

	public List<Product> listByCatagoryId(int catagoryId) {
		// TODO Auto-generated method stub
	Session session=getSession();
		

		Query query =session.createQuery("from Product where productCatagory.catagoryId = :catagoryId ");  // HQL
		
		query.setParameter("catagoryId", catagoryId);
		List <Product> catagoryList=query.list();
		session.close();
		if (catagoryList ==null || catagoryList.isEmpty() )
		{
			return null;
		}
		else
		{
			return catagoryList;
		}
		
		
		
		
		
	}

	@Override
	public Product listByProductId(int productId) {
		// TODO Auto-generated method stub
		Session session=getSession();
Query query =session.createQuery("from Product where productId = :productId ");  // HQL
		
		query.setParameter("productId", productId);
		List <Product> productList=query.list();
		session.close();
		if (productList ==null || productList.isEmpty() )
		{
			return null;
		}
		else
		{
			return productList.get(0);
		}
	}

	
	
	
}
