package com.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("jiotagging")
public class JioTaggingController {

	@RequestMapping(value="/jiodistance", method =RequestMethod.GET )
	public ModelAndView getDistacne(){
		ModelAndView view =new ModelAndView("jioTag");
		return view;
	}
}
