package ua.service.impl;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.entity.Meal;
import ua.model.request.MealRequest;
import ua.model.view.MealView;
import ua.repository.MealRepository;
import ua.service.MealService;

@Service
public class MealServiceImpl implements MealService{

	private final MealRepository repository;

	public MealServiceImpl(MealRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<String> findAllCuisines() {
		return repository.findAllCuisines();
	}

	@Override
	public List<String> findAllIngredients() {
		return repository.findAllIngredients();
	}

	@Override
	@Transactional(readOnly=true)
	public List<MealView> findAllMealByCafeId(Principal principal) {
		List<MealView> views = repository.findAllMealsByUserEmail(principal.getName());
		views.forEach(this::loadIngredients);
		return views;
	}
	
	private void loadIngredients(MealView view) {
		view.setIngredients(repository.findAllIngredientsByMealId(view.getId()));
	}

	@Override
	public void delete(Integer id) {
		repository.delete(id);
	}
	
	
	@Override
	public void save(MealRequest request,String photo) {
		Meal meal = new Meal();
		meal.setCafe(request.getCafe());
		meal.setCuisine(request.getCuisine());
		meal.setDescription(request.getDescription());
		meal.setId(request.getId());
		meal.setIngredients(request.getIngredients());
		meal.setPhotoUrl(photo);
		meal.setPrice(new BigDecimal(request.getPrice()));
		meal.setTitle(request.getTitle());
		meal.setVersion(request.getPhotoUrl() != null && request.getPhotoUrl().equals(photo) ? request.getVersion() + 1 : 0);
		meal.setWeight(Integer.valueOf(request.getWeight()));
		repository.save(meal);
	}

	@Override
	public MealRequest findOne(Integer id) {
		Meal meal = repository.findOneRequest(id);
		MealRequest request = new MealRequest();
		request.setCafe(meal.getCafe());
		request.setCuisine(meal.getCuisine());
		request.setDescription(meal.getDescription());
		request.setId(meal.getId());
		request.setIngredients(meal.getIngredients());
		request.setPhotoUrl(meal.getPhotoUrl());
		request.setPrice(String.valueOf(meal.getPrice()));
		request.setTitle(meal.getTitle());
		request.setVersion(meal.getVersion());
		request.setWeight(String.valueOf(meal.getWeight()));
		return request;
	}

	@Override
	public List<String> findAllCafeByUserEmail(String email) {
		return repository.findAllCafeByUserEmail(email);
	}

	@Override
	public List<Meal> findAllView() {
		return repository.findAllView();
	}

	@Override
	public List<Meal> findAllMealsByCafeId(Integer id) {
		return repository.findAllMealsByCafeId(id);
	}

	@Override
	public List<Meal> findMealsByCuisineId(Integer id) {
		return repository.findMealsByCuisineId(id);
	}

	
	


}
