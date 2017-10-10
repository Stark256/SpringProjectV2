package ua.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.model.filter.CafeFilter;
import ua.model.filter.MealFilter;
import ua.repository.CafeViewRepository;
import ua.repository.MealViewRepository;
import ua.service.CuisineService;
import ua.service.IngredientService;

@Controller
@RequestMapping("/all")
public class SeeAllController {
	
	private final CafeViewRepository repository;

//private final CafeService cafeService;

private final MealViewRepository mealRep;


private final CuisineService cuisineService;

private final IngredientService service;
	
	@Autowired
	public SeeAllController(MealViewRepository mealRep,CafeViewRepository repository,IngredientService service,CuisineService cuisineService) {
		this.repository = repository;
		this.mealRep = mealRep;
		this.service = service;
		this.cuisineService = cuisineService;
	}
	
	@ModelAttribute("cafeFilter")
	public CafeFilter getFilter(){
		return new CafeFilter();
	}
	
	@ModelAttribute("mealFilter")
	public MealFilter getFilterMeal(){
		return new MealFilter();
	}
	
	@GetMapping("/allcafe")
	public String showAllCafe(Model model , @ModelAttribute("cafeFilter") CafeFilter filter, @PageableDefault Pageable pageable){
		model.addAttribute("cafes",repository.findAll(filter, pageable));
		return "allcafe";
	}
	
	@GetMapping("/allmeal")
	public String showAllMeal(Model model,@ModelAttribute("mealFilter") MealFilter filter, @PageableDefault Pageable pageable) {
		model.addAttribute("meals", mealRep.findAll(filter, pageable));
		model.addAttribute("cuisines", cuisineService.findAll());
		model.addAttribute("ingredients", service.findAll());
		return "allmeal";
	}
}
