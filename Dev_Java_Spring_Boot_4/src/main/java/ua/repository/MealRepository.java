package ua.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ua.entity.Cafe;
import ua.entity.Meal;
import ua.model.view.MealView;

public interface MealRepository extends JpaRepository<Meal, Integer> {

	@Query("SELECT c.name FROM Cuisine c")
	List<String> findAllCuisines();
	
	@Query("SELECT i.name FROM Ingredient i")
	List<String> findAllIngredients();
	
	@Query("SELECT new ua.model.view.MealView(m.id, m.title, m.description, m.price, m.photoUrl, m.version, c.name, m.weight,cafe.name) FROM Meal m JOIN m.cuisine c LEFT JOIN m.cafe cafe WHERE m.cafe.id=?1")
	List<MealView> findAllMealByCafeId(Integer id);
	
	@Query("SELECT m FROM Meal m WHERE m.cafe.id=?1")
	List<Meal> findAllMealsByCafeId(Integer id);
	
	@Query("SELECT i.name FROM Ingredient i JOIN i.meals m WHERE m.id=?1")
	List<String> findAllIngredientsByMealId(Integer id);
	
	@Query("SELECT DISTINCT m FROM Meal m JOIN FETCH m.cuisine LEFT JOIN FETCH m.ingredients WHERE m.id=?1")
	Meal findOneRequest(Integer id);
	
	@Query("SELECT c.name FROM Cafe c WHERE c.user.email=?1")
	List<String> findAllCafeByUserEmail(String email);
	
	@Query("SELECT new ua.model.view.MealView(m.id, m.title, m.description, m.price, m.photoUrl, m.version, c.name, m.weight,cafe.name) FROM Meal m JOIN m.cuisine c LEFT JOIN m.cafe cafe LEFT JOIN cafe.user u WHERE u.email=?1")
	List<MealView> findAllMealsByUserEmail(String email);
	
	@Query("SELECT c FROM Cafe c WHERE c.name=?1")
	Cafe findCafeByName(String name);
	
	@Query("SELECT m FROM Meal m WHERE m.title=?1")
	Meal findByName(String name);
	
	@Query("SELECT m FROM Meal m ")
	List<Meal> findAllView();
	
	@Query("SELECT m FROM Meal m WHERE m.cuisine.id=?1")
	List<Meal> findMealsByCuisineId(Integer id);
}
