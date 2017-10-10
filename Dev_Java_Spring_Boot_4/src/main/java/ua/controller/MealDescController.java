package ua.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import ua.service.MealService;

@Controller
@RequestMapping("/mealdesc")
@SessionAttributes("comment")
public class MealDescController {
	
	private final MealService service;

	@Autowired
	public MealDescController(MealService service) {
		super();
		this.service = service;
	}
	
	@GetMapping("/{id}")
	public String desc(@PathVariable Integer id, Model model){
		model.addAttribute("meal", service.findOne(id));
		return "mealdesc";
	}
	

}
