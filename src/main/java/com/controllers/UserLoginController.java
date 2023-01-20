package com.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.entities.Login;
import com.entities.Users;
import com.servicesapi.UsersService;

@RestController
@RequestMapping("userlogin")
public class UserLoginController {

	  @Autowired
	  UsersService usersService;
	 
	  @RequestMapping(value="/login", method = RequestMethod.GET )
		public ModelAndView getLogin(){
			ModelAndView view =new ModelAndView("user");
			return view;
		}
	  
	  @RequestMapping(value="/validateUser", method=RequestMethod.POST)
	  public @ResponseBody Map<String,Object> getvalidate(Login login)
	  {
	  Map<String,Object> map = new HashMap<String,Object>();
	  
	  List<Users> list = usersService.validateUser(login);
	  
	  if(list.size() > 0)
	  { 
	   map.put("status","200");
	  map.put("message","user  login successfully");
       map.put("message", "welcome");
       map.put("data", list);
	  }else {
		  map.put("status","404");
		  map.put("message","invalid username and password");
	}
	  
	  return map; 
	  }
	 

}
