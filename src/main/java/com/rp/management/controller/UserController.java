package com.rp.management.controller;

import org.aspectj.weaver.NewConstructorTypeMunger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rp.management.service.UserService;
import com.rp.management.web.dto.UserRegistrationDto;

@Controller
@RequestMapping("/registration")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@GetMapping
	public String showRegistrationForm(Model model) {
		model.addAttribute("user", new UserRegistrationDto());
		return "registration";
	}
	
	
	@PostMapping
	public String userRegistration(@ModelAttribute("user") UserRegistrationDto userRegistrationDto) {
		userService.saveUser(userRegistrationDto);
		return "redirect:/registration?success";
	}
	

}
