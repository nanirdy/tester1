package com.controllers;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.entities.Users;
import com.entities.chats;
import com.servicesapi.UsersService;


@RestController
@RequestMapping("chat")
public class ChatController {

	@Autowired
	UsersService userServices;
	SessionFactory session;

	@RequestMapping(value ="/page", method = RequestMethod.GET)
	public ModelAndView getPage() {
		ModelAndView view = new ModelAndView("chat");
		return view;
	}

	@RequestMapping(value ="/grppage", method = RequestMethod.GET)
	public ModelAndView getGroupPage() {
		ModelAndView view = new ModelAndView("groupchat");
		return view;
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> getAll(Users users) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Users> list = userServices.list();

		if (list != null) {
			map.put("status", "200");
			map.put("message", "Data found");
			map.put("data", list);
		} else {
			map.put("status", "404");
			map.put("message", "Data not found");

		}
		return map;
	}
	
	
	@RequestMapping(value = "/send", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> getSaved(chats chat) {
		Map<String, Object> map = new HashMap<String, Object>();

		System.out.println(chat.getReceiverid());
		
		
		
		if (userServices.saveOrUpdate(chat)) {
			map.put("status", "200");
			map.put("message", "Your record have been saved successfully");
		}

		return map;
	}

	
	@RequestMapping(value = "/retrieve", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> getRetrieve(Users user) {
		Map<String, Object> map = new HashMap<String, Object>();

		if (userServices.retrieve(user)) {
			map.put("status", "200");
			map.put("message", "user records retrieve successfully");
		}

		return map;
	}
	@RequestMapping(value = "/retrieve1", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> getRetrieve(chats chat) {
		Map<String, Object> map = new HashMap<String, Object>();
	
		List<chats> list = userServices.retrieve(chat);
		
		if (list.size() > 0) {
			map.put("status", "200");
			map.put("data", list);
			map.put("message", "user records retrieve successfully");
		}else {
			map.put("status", "404");
		}
	
		return map;
	}
	

}