/**
 * 
 */
package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.model.Catagory;
import com.niit.shoppingcart.model.Product;
/**
 * @author Jo
 *
 */
public interface ProductDAO {
public List<Product> list();
public Product listByProductId(int productId);
	public List<Product> listByCatagoryId(int catagoryId);
}
