package com.niit.crud.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.niit.crud.dao.UsersDao;
import com.niit.crud.model.Users;

@Controller  
public class UserController {
	  @Autowired 
	  UsersDao usersDao;
	  @RequestMapping("/index")  
	    public ModelAndView index(){  
	        return new ModelAndView("index");  
	    } 
	  
	@RequestMapping("/usersform")  
    public ModelAndView showform(){  
        return new ModelAndView("usersform","command",new Users());  
    } 
	
	 /*It saves object into database. The @ModelAttribute puts request data 
     *  into model object. You need to mention RequestMethod.POST method  
     *  because default request is GET*/  
    @RequestMapping(value="/save",method = RequestMethod.POST)  
    public ModelAndView save(@ModelAttribute("users") Users users , HttpServletRequest request, 
			@RequestParam("file") MultipartFile file){  
    	
    	///////////////////////////////
    	
		byte fileBytes[];
		FileOutputStream fos = null;
		
		String fileName = "";
		String userImage = "";
		ServletContext context = request.getServletContext();
		String realContextPath = context.getRealPath("/");
		String un = users.getUserName();
		if (file != null){
			fileName = realContextPath + "/resources/img/" + un + ".jpg";
			userImage = "resources/img/" + un + ".jpg";
			System.out.println("===" + fileName + "===");
			File fileobj = new File(fileName);
			try{
				fos = new FileOutputStream(fileobj);
				fileBytes = file.getBytes();
				fos.write(fileBytes);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		/*String sid=product.getSupplier().getId();
		String cid=product.getCategory().getId();*/
		
		users.setUserImage(userImage);	
		
		/*Supplier ss=supplierDAO.get(sid);
		Category cc=categoryDAO.get(cid);
		
		product.setCategory(cc);
		product.setSupplier(ss);*/
		
		  	
    	
    	
    	//////////////////////////////
    	
    	
    	
    	
    	
    	
    	usersDao.addUsers(users);
        return new ModelAndView("redirect:/viewusers");//will redirect to viewusers request mapping  
    }  
    
    /* It provides list of users in model object */  
    @RequestMapping("/viewusers")  
    public ModelAndView viewusers(){  
        List<Users> list=usersDao.getAllUsers();
        return new ModelAndView("viewusers","list",list);  
    }  
    
    /* It displays object data into form for the given id.  
     * The @PathVariable puts URL data into variable.*/  
    @RequestMapping(value="/editusers/{id}")  
    public ModelAndView edit(@PathVariable int id){  
        Users users=usersDao.getUsersById(id);  
        ModelAndView mv=new ModelAndView("userseditform","command",users);  
        System.out.println(users.getUserName()+" mmmmmmm "+users.getUserImage());
        mv.addObject("photo",users.getUserImage());
        return mv;  
    }  
    
    
    /* It updates model object. */  
    @RequestMapping(value="/editsave",method = RequestMethod.POST)  
    public ModelAndView editsave(@ModelAttribute("users") Users users , HttpServletRequest request, 
			@RequestParam("file") MultipartFile file){  
    	
///////////////////////////////
    	if (file.getSize()!=0)
    		
    	{
    		
    		System.out.println("uiuiuiuiuiuiu"+ file.getSize());
byte fileBytes[];
FileOutputStream fos = null;

String fileName = "";
String userImage = "";
ServletContext context = request.getServletContext();
String realContextPath = context.getRealPath("/");
String un = users.getUserName();
if (file != null){
	System.out.println(" file not null");
fileName = realContextPath + "/resources/img/" + un + ".jpg";
userImage = "resources/img/" + un + ".jpg";
System.out.println("===" + fileName + "===");
File fileobj = new File(fileName);
try{
fos = new FileOutputStream(fileobj);
fileBytes = file.getBytes();
fos.write(fileBytes);
fos.close();
} catch(Exception e) {
e.printStackTrace();
}
}

/*String sid=product.getSupplier().getId();
String cid=product.getCategory().getId();*/

users.setUserImage(userImage);	
    	}
/*Supplier ss=supplierDAO.get(sid);
Category cc=categoryDAO.get(cid);

product.setCategory(cc);
product.setSupplier(ss);*/




//////////////////////////////
    	
    	
    	
    	
    	
    	
    	
    	
    	usersDao.updateUsers(users);
        return new ModelAndView("redirect:/viewusers");  
    }  
    
    /* It deletes record for the given id in URL and redirects to /viewusers */  
    @RequestMapping(value="/deleteusers/{id}",method = RequestMethod.GET)  
    public ModelAndView delete(@PathVariable int id){ 
    	System.out.println("delete is called");
       usersDao.deleteUsers(id);
        return new ModelAndView("redirect:/viewusers");  
    }  
}
