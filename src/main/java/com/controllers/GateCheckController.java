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

import com.entities.GateCheck;
import com.servicesapi.UsersService;

@RestController
@RequestMapping("gatecheck")
public class GateCheckController {
   
	@Autowired
	UsersService userServices;
	
	@RequestMapping(value="/page",method=RequestMethod.GET)
	public ModelAndView getPage() {
		ModelAndView view = new ModelAndView("gate");
		return view;
	}
	
	@RequestMapping(value = "/saveOrUpdate1", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> getSaved(GateCheck gatecheck) {
		Map<String, Object> map = new HashMap<String, Object>();

		if (userServices.saveOrUpdate1(gatecheck)) {
			map.put("status", "200");
			map.put("message", "Your record have been saved successfully");
		}

		return map;
	}

	@RequestMapping(value = "/list1", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> getAll(GateCheck gatecheck) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<GateCheck> list1 = userServices.list1();

		if (list1 != null) {
			map.put("status", "200");
			map.put("message", "Data found");
			map.put("data", list1);
		} else {
			map.put("status", "404");
			map.put("message", "Data not found");

		}

		return map;
	}

	@RequestMapping(value = "/Update", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> getupdate(GateCheck gatecheck){
		Map<String, Object> map = new HashMap<String, Object>();

		if (userServices.Update(gatecheck)){
			map.put("status", "200");
			map.put("message", "Your record have been saved successfully");
		}

		return map;
	}
	
	@RequestMapping(value = "/Update1", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> getupdate1(GateCheck gatecheck){
		Map<String, Object> map = new HashMap<String, Object>();

		if (userServices.Update1(gatecheck)){
			map.put("status", "200");
			map.put("message", "Your record have been saved successfully");
		}

		return map;
	}
	
	@RequestMapping(value = "/Update2", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> getupdate2(GateCheck gatecheck){
		Map<String, Object> map = new HashMap<String, Object>();

		if (userServices.Update2(gatecheck)){
			map.put("status", "200");
			map.put("message", "Your record have been saved successfully");
		}

		return map;
	}
	
}
