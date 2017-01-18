/**
 * 
 */
package com.niit.shoppingcart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.CatagoryDAO;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.dao.UserDAO;





/**
 * @author Jo
 *
 */
@Controller
public class HomeController {
	@Autowired
	CatagoryDAO catagoryDAO;
	
	@Autowired
	ProductDAO productDAO;
	
	/*@Autowired 
	UserDAO userDAO;*/
	
@RequestMapping("/home")
	
	public ModelAndView home()
	{
		
		ModelAndView mv=new ModelAndView("menu");   
		mv.addObject("catagoryList", catagoryDAO.list());
		//mv.addObject("productList", productDAO.list());
		//mv.addObject("userList", userDAO.list());
		System.out.println("home home");
		return mv;
	}
	

@RequestMapping("/viewProducts/{catagoryId}")
public ModelAndView  viewCatagory(@PathVariable int catagoryId)
{
	
	ModelAndView mv=new ModelAndView("products");
	mv.addObject("productList", productDAO.listByCatagoryId(catagoryId));
	//System.out.println("No of catagory: "+catagoryDAO.listByCatagoryId(catagoryId).size());
	return mv;
}

@RequestMapping("/showProduct/{productId}")
public ModelAndView  viewProduct(@PathVariable int productId)
{
	
	ModelAndView mv=new ModelAndView("product");
	mv.addObject("product", productDAO.listByProductId(productId));
	//System.out.println("No of catagory: "+catagoryDAO.listByCatagoryId(catagoryId).size());
	return mv;
}






}
