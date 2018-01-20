package com.controller; 
import org.springframework.beans.factory.annotation.Autowired; 
 import org.springframework.stereotype.Controller; 
 import org.springframework.ui.Model; 
 import org.springframework.validation.BindingResult; 
 import org.springframework.web.bind.annotation.ModelAttribute; 
 import org.springframework.web.bind.annotation.RequestMapping; 
 import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.DAO.CategoryDAO;
import com.DAO.ProductDAO;
import com.DAO.UserDAO;
import com.DAOImpl.CategoryDAOImpl;
import com.DAOImpl.ProductDAOImpl;
import com.model.User; 
 
 
 
 @Controller 
 public class IndexController  
 { 
 	@Autowired 
   UserDAO userDAO; 
 	@Autowired 
 	ProductDAO  productDAO; 
 	@Autowired 
 	CategoryDAO categoryDAO; 
 	 
 	 
 	@RequestMapping("/") 
 	public String index() 
 	{ 
 	 
 		return "index"; 
 	} 
 
 
 	@RequestMapping("/index") 
 	public String home() 
 	{ 
 	 
 		return "index"; 
 	} 
 	@RequestMapping(value="/goToregister",method=RequestMethod.GET) 
 	public ModelAndView goTOregister() 
 	{ 
 		ModelAndView mv= new ModelAndView(); 
 		mv.addObject("user",new User()); 
 
 
 		mv.setViewName("register"); 
 		return mv; 
 		 
 		 
 	} 
 	@RequestMapping(value="/saveUser",method=RequestMethod.POST) 
 	public ModelAndView saveUserData(@ModelAttribute("user")User user,BindingResult result) 
 	{ 
 		ModelAndView mv=new ModelAndView(); 
 		if(result.hasErrors()) 
 		{ 
 			mv.setViewName("register"); 
 			return mv; 
 		} 
 		else{ 
 			user.setRole("ROLE_USER"); 
 			user.setEnabled(true);
 			userDAO.insertUser(user); 
 			mv.setViewName("index"); 
 			} 
 		return mv; 
 	} 
 	 
 	/*@RequestMapping(value="/productCustList") 
 	public ModelAndView getCustTable(@RequestParam("cid")int cid) 
 	{ 
 		ModelAndView mv=new ModelAndView(); 
 		mv.addObject("prodList",ProductDAOImpl.getProdByCatId(cid)); 
 		mv.setViewName("productCustList"); 
 		return mv; 
 	} */
 	@RequestMapping(value="/goTologin",method=RequestMethod.GET) 
 	public ModelAndView goTOlogin() 
 	{ 
 		ModelAndView mv= new ModelAndView(); 
 
 
 		mv.setViewName("login"); 
 		return mv; 
 		 
 		 
 	} 
 	 
 	@RequestMapping("/userlogged") 
       public String login(){ 
 		return "redirect:/"; 
 	} 
        
 	 @RequestMapping("/error") 
 	public String userError() 
 	{ 
 		return "error"; 
 	} 
 	@RequestMapping("/relogin") 
 	public String relogin() 
 	{ 
 		return "redirect:/goTologin"; 
 	} 
         } 
