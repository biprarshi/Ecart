/**
 * 
 */
package com.niit.crud.dao;

import com.niit.crud.model.Cart;

/**
 * @author Jo
 *
 */
public interface CartDao {

	public boolean saveOrUpdate(Cart cart);
	
	public boolean delete(Cart cart);
	
	public Cart getCartByUserId(String userId);
	
}
