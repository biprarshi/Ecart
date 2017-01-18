/**
 * 
 */
package com.niit.shoppingcart.dao;

import java.util.List;

/**
 * @author Jo
 *
 */

import com.niit.shoppingcart.model.*;
public interface CatagoryDAO {
	public List<Catagory> list();
	public Catagory listByCatagoryId(int catagoryId);
}
