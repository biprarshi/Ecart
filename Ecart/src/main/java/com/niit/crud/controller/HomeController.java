package com.niit.crud.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.crud.dao.CartDao;
import com.niit.crud.dao.CategoryDao;
import com.niit.crud.dao.ProductDao;
import com.niit.crud.dao.UserDao;
import com.niit.crud.model.Cart;
import com.niit.crud.model.User;
import com.niit.crud.model.Users;

@Controller  
public class HomeController {
	 @Autowired 
	  CategoryDao categoryDao;
	 @Autowired 
	 ProductDao productDao;
	 @Autowired 
	 UserDao userDao;
	 
	 @Autowired
	 CartDao cartDao;
	 @RequestMapping(value = "/loginPage", method = RequestMethod.GET)
		public ModelAndView loginPage() {

			return new ModelAndView("loginPage");
		}
	 @RequestMapping(value = "/register", method = RequestMethod.GET)
		public ModelAndView register() {

		 return new ModelAndView("register","command",new User());  
		}
	 
	 @RequestMapping(value="/saveUser",method = RequestMethod.POST)  
	    public ModelAndView save(@ModelAttribute("user") User user){  
		 Cart c=new Cart();
		 cartDao.saveOrUpdate(c);
		 user.setCart(c);
		 
	    userDao.addUsers(user);
	    
	    
	    c.setUser(user);
	    cartDao.saveOrUpdate(c);
	        return new ModelAndView("redirect:/register");//will redirect to viewusers request mapping  
	    }  
	 
	 @RequestMapping("/home")  
	    public ModelAndView index(HttpSession session){  
		 ModelAndView mv= new ModelAndView("home");
		 session.setAttribute("categoryList", categoryDao.list());
		 mv.addObject("categoryList", categoryDao.list());
	        return mv;  
	    } 
	 
	 @RequestMapping("/home1")  
	    public ModelAndView index1(){  
		 ModelAndView mv= new ModelAndView("home");
		// mv.addObject("productList", productDao.list());
	        return mv;  
	    } 
	 
	 @RequestMapping("/showProductsByCategory/{categoryId}")  
	    public ModelAndView showProductsByCategory(@PathVariable int categoryId ){  
		 System.out.println("cat id "+categoryId);
		 ModelAndView mv= new ModelAndView("products");
		 mv.addObject("productList", productDao.listByCategoryId(categoryId));
	        return mv;  
	    } 
	 
	 
	 @RequestMapping("/showProduct/{productId}")  
	    public ModelAndView showProduct(@PathVariable int productId ){  
		 
		 ModelAndView mv= new ModelAndView("product");
		 mv.addObject("product", productDao.listByProductId(productId));
	        return mv;  
	    } 
	 
	 
	 
	 
}
