package ua.controller;


import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ua.service.CafeIndexService;

@Controller
public class MainController {

private final CafeIndexService service;
	
	@Autowired
	public MainController(CafeIndexService service) {
		this.service = service;
	}
	
	@GetMapping("/")
	public String index(Model model, Principal principal) {
		/*if(user!=null) {
			model.addAttribute("message", "Hello "+user.getEmail());
			System.out.println(user.getRole());
			System.out.println(user.getPassword());
		} else {
			model.addAttribute("message", "Hello unregistered user");
		}*/
		if(principal!=null){
		model.addAttribute("message", "Hello "+principal.getName());
		}else{
			model.addAttribute("message", "Hello unregister user");
		}
		model.addAttribute("cafes", service.findTopFiveCafe());
		return "index";
	}
	
	@GetMapping("/admin")
	public String admin() {
		return "admin";
	}
}
