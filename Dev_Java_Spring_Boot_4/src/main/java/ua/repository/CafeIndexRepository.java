package ua.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import ua.entity.Cafe;
import ua.entity.Meal;
import ua.model.view.CafeIndexView;

public interface CafeIndexRepository extends JpaNameRepository<Cafe>{

	@Query("SELECT new ua.model.view.CafeIndexView(c.id, c.rate, c.name, c.photoUrl, c.version, c.address, c.shortDescription, c.type) FROM Cafe c ORDER BY c.rate DESC")
	List<CafeIndexView> findAllCafes();
	
	@Query("SELECT m FROM Meal m JOIN m.cuisine WHERE m.cafe.id=?1")
	List<Meal> findMealByCafeId(Integer id);
	
}
