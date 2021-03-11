package com.ali.springsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/administrators")
	public String administrators() {
		return "administrators";
	}
	
	@GetMapping("development")
	public String development() {
		return "development";
	}
	
}
