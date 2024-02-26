package com.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "home_site";
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String createFlashcard() {
		return "createFlashcard";
	}
}
