/**
 * 
 */
package com.niit.crud.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.crud.dao.CartDao;
import com.niit.crud.dao.CartItemDao;
import com.niit.crud.dao.CategoryDao;
import com.niit.crud.dao.ProductDao;
import com.niit.crud.dao.UserDao;
import com.niit.crud.dao.UsersDao;
import com.niit.crud.model.Cart;
import com.niit.crud.model.CartItem;
import com.niit.crud.model.Product;
import com.niit.crud.model.User;

/**
 * @author Jo
 *
 */
@Controller
public class CartController {
	@Autowired 
	  CategoryDao categoryDao;
	 @Autowired 
	 ProductDao productDao;
	 @Autowired 
	 UserDao userDao;
	 @Autowired
	 CartDao cartDao;
	 @Autowired
	 CartItemDao cartItemDao;
	 
	
	 @RequestMapping("/cart/showCart")
	 public ModelAndView showProduct(HttpSession session){
		 
		 ModelAndView mv = new ModelAndView("cart");
		 Cart cart= (Cart) session.getAttribute("cart");
		 if(cart==null)
		 {
			 mv.addObject("errMsg", "No Items in Cart");
		 }
		 else
		 {
			 mv.addObject("cartContent", cart.getCartItems());
			 mv.addObject("grandTotal", cart.getGrandTotal());
		 }
		 return mv;
	 }
	 
	 private void updateCart(CartItem cartItem)
	 {
		 Cart c1=cartItem.getCart();
		 c1.setGrandTotal(c1.getGrandTotal()+cartItem.getProduct().getProductPrice());
		 cartDao.saveOrUpdate(c1);
	 }
	 
	 @RequestMapping("/cart/addItem/{productId}")
	 public ModelAndView addItemToCart(@PathVariable int productId, Principal principal, HttpSession session){
		 ModelAndView mv = new ModelAndView("redirect:/cart/showCart");
		 String id = principal.getName();
		 System.out.println("logged in user "+id);
		 Product product = productDao.listByProductId(productId);
		 User u=userDao.getUsersById(id);
		 //Cart cart = cartDao.getCartByUserId(id);
		 Cart cart=u.getCart();
		 if(cart==null)
		 {
			 System.out.println("No cart ");
			 Cart c = new Cart();
			 User user = userDao.getUsersById(id);
			 
			 c.setUser(user);
			 cartDao.saveOrUpdate(c);
			 user.setCart(c);
			 userDao.editUsers(user);
			 
			 CartItem cartItem = new CartItem();
			 cartItem.setCart(c);
			 cartItem.setProduct(product);
			 cartItem.setQuantity(1);
			 cartItem.setSubTotal(product.getProductPrice());
			 cartItemDao.saveOrUpdate(cartItem);
			 updateCart(cartItem);
			 session.setAttribute("cart", cartItem.getCart());
			 
			 return mv;
		 }
		 
		 System.out.println("Yes cart");
		 
		 List <CartItem> cartItems = cart.getCartItems();
		 
		 for(CartItem cartItem:cartItems)
		 {
			if(cartItem.getProduct().getProductId()==productId)
			{
				cartItem.setQuantity(cartItem.getQuantity()+1);
				cartItem.setSubTotal(cartItem.getSubTotal()+product.getProductPrice());
				cartItemDao.saveOrUpdate(cartItem);
				updateCart(cartItem);
				session.setAttribute("cart", cartItem.getCart());
				return mv;
			}
		 }
		 
		 CartItem item = new CartItem();
		 item.setCart(cart);
		 item.setProduct(product);
		 item.setQuantity(1);
		 item.setSubTotal(product.getProductPrice());
		 cartItemDao.saveOrUpdate(item);
		 updateCart(item);
		 session.setAttribute("cart", item.getCart());
		 return mv;
		 
	 }
}
