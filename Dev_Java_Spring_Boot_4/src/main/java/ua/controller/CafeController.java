package ua.controller;

import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.service.CafeService;

@Controller
@RequestMapping("/cafe")
public class CafeController {

	private final CafeService service;
	
	@Autowired
	public CafeController(CafeService service) {
		this.service = service;
	}
	
	
	
	@GetMapping
	public String show(Model model,Principal principal) {
		model.addAttribute("cafes",service.findAllCafeByUserEmail(principal.getName()));
		
		return "cafe";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id) {
		service.delete(id);
		return "redirect:/cafe";
	}
	
	

}
