package com.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.entities.Admin;
import com.entities.Login;
import com.servicesapi.UsersService;

@Controller
@RequestMapping("adminlogin")
public class AdminLoginController {

	@Autowired
	UsersService usersService;
	
	@RequestMapping(value="/login1", method =RequestMethod.GET )
	public ModelAndView getLogin(){
		ModelAndView view =new ModelAndView("user1");
		return view;
	}
	
	/* @RequestMapping(value="/validateAdmin", method=RequestMethod.POST)
	 public @ResponseBody Map<String,Object> getvalidate(Login login1)
	 {
	  Map<String,Object> map = new HashMap<String,Object>();
	  
	  if(usersService.validateAdmin(login1))
	  { 
		  map.put("status","200");
		  map.put("message","admin  login successfully"); 
	  
	  }else {
		  map.put("status","404");
		  map.put("message","invalid username and password");
	  }
	
	  return map; 
	 }
	 */
	  @RequestMapping(value="/validateAdmin", method=RequestMethod.POST)
	  public @ResponseBody Map<String,Object> getvalidate(Login login1)
	  {
	  Map<String,Object> map = new HashMap<String,Object>();
	  
	  List<Admin> list = usersService.validateAdmin(login1);
	  
	  if(list.size() > 0)
	  { 
	   map.put("status","200");
	  map.put("message","admin  login successfully");
       map.put("message", "welcome");
       map.put("data", list);
	  }else {
		  map.put("status","404");
		  map.put("message","invalid username and password");
	}
	  
	  return map; 
	  }
	
}
