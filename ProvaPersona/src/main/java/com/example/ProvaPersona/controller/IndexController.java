package com.example.ProvaPersona.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
 public class IndexController {
	
		@RequestMapping(value="/" , method=RequestMethod.GET)
		public String index(HttpServletRequest request, ModelMap modelMap){
			return "index";
		}
}
