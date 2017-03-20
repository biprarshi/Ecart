package com.niit.crud.dao;
import java.util.List;

import com.niit.crud.model.User;
import com.niit.crud.model.Users;



public interface UserDao {
	public void addUsers(User users);

	public User getUsersById(String userId);

	public List<User> getAllUsers(String un);

	public User getUsersByUsername(String userName);
	public void editUsers(User users);
}
