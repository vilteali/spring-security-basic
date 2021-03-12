package com.ali.springsecurity.controller;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ali.springsecurity.entity.User;
import com.ali.springsecurity.model.CRMUser;
import com.ali.springsecurity.service.UserService;

import jakarta.validation.Valid;

@Controller
public class RegistrationController {

	@Autowired
	private UserService userService;
	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
		
	}
	
	@GetMapping("/registrationForm")
	public String registrationForm(Model model) {
		
		model.addAttribute("crmUser", new CRMUser());
		
		return "registrationForm";
	}
	
	@PostMapping("/processRegistrationForm")
	public String processRegistrationForm(@Valid @ModelAttribute("crmUser") CRMUser crmUser,
			BindingResult bindingResult, Model model) {
		
		String userName = crmUser.getUsername();
		logger.info("Processing registration form for: "+userName);
		
		// validate form
		if(bindingResult.hasErrors()) {
			return "registrationForm";
		}
		
		// check the database if user already exists
		User userExists = userService.findByUserName(userName);
		
		if(userExists != null) {
			model.addAttribute("crmUser", crmUser);
			model.addAttribute("registrationError", "User name already exists.");
			logger.warning("User name already exists.");
			
			return "registrationForm";
		}
		
		userService.save(crmUser);
		logger.info("Successfully created user: "+userName);
		
		return "registrationConfirmation";
	}
	
}
