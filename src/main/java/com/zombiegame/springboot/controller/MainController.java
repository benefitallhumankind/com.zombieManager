package com.zombiegame.springboot.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	@RequestMapping("/")
	public String viewHome() {
		return "index";
	}
	@RequestMapping("/main")
	public String viewMain(HttpSession session) {
		if(session.getAttribute("account") == null) {
			return "redirect:/signin";
		}
		return "main";
	}
}
