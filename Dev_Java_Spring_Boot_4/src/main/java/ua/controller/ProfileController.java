package ua.controller;


import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import ua.service.CafeService;

@Controller
@RequestMapping("/profile")
@SessionAttributes("profile")
public class ProfileController {

private final CafeService service;

	
	@Autowired
	public ProfileController(CafeService service) {
		this.service = service;
	}
	
	@GetMapping
	public String show(Model model,Principal principal) {
		model.addAttribute("cafes",service.findAllCafeByUserEmail(principal.getName()));
		model.addAttribute("user", service.findOneUserByEmail(principal.getName()));
		return "profile";
	}
	
	
	
	
	
	
	
}
