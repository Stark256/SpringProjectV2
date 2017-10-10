package ua.controller;



import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.service.MealService;

@Controller
@RequestMapping("/meal")
//@SessionAttributes("meal")
public class MealController {

	private final MealService service;
	
	@Autowired
	public MealController(MealService service) {
		this.service = service;
	}

	@GetMapping
	public String show(Model model,Principal principal) {
		model.addAttribute("meals", service.findAllMealByCafeId(principal));
		return "meal";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id) {
		service.delete(id);
		return "redirect:/meal";
	}
}
