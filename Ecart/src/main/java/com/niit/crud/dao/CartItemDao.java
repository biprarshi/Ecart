/**
 * 
 */
package com.niit.crud.dao;

import java.util.List;

import com.niit.crud.model.Cart;
import com.niit.crud.model.CartItem;

/**
 * @author Jo
 *
 */
public interface CartItemDao {

	public boolean saveOrUpdate(CartItem cartItem);
	
	public boolean delete(CartItem cartItem);
	
	public CartItem get(String cartItemId);
	
	public List<CartItem> getCartItemByUserId(String userId);
}
