package com.niit.crud.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.crud.model.User;





@Repository("userDao")
@Transactional
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	protected Session getSession() {
		return sessionFactory.openSession();
	}

	public void addUsers(User user) {
		// TODO Auto-generated method stub

		Session session = getSession();

		

		user.setEnabled(true);
		user.setRole("ROLE_USER");

		
		session.save(user);

		session.flush();

		session.close();

	}

	public User getUsersById(String userId) {
		// TODO Auto-generated method stub
		Session session = getSession();
		
		Query query = session.createQuery("from User where userId = :un");
		query.setParameter("un", userId);
		User u=(User) query.uniqueResult(); 
		session.flush();
		session.close();
		return  u;
		
	}

	public List<User> getAllUsers(String un) {
		// TODO Auto-generated method stub
		Session session = getSession();

		Query query = session.createQuery("from User where userName != :un");
		query.setParameter("un", un);
		List<User> customerList = query.list();

		return customerList;

	}

	public User getUsersByUsername(String userName) {
		// TODO Auto-generated method stub
		Session session = getSession();

		Query query = session.createQuery("from User where username = ?");
		query.setString(0, userName);

		return (User) query.uniqueResult();

	}

	
	public void editUsers(User users)
	 {
		 //Transaction tx = getSession().beginTransaction();
		 Session s=getSession();
		 
		 users.setEnabled(true);
		 s.update(users);
		 s.flush();
		 s.close();
		// tx.commit();
	 }

	
}