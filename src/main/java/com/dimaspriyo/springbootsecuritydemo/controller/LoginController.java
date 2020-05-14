package com.dimaspriyo.springbootsecuritydemo.controller;

import java.lang.ProcessBuilder.Redirect;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller

public class LoginController {

	@RequestMapping("")
	public String redirectLogin() {
		
		return "redirect:/login";
		
	}
	
	@RequestMapping("/login")
	public String login(){
		return "login";
	}
	
}
