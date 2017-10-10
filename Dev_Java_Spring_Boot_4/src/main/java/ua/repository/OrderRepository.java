package ua.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ua.entity.Order;
import ua.entity.Table;
import ua.model.view.OrderView;

public interface OrderRepository extends JpaRepository<Order, Integer>{
	
	@Query("SELECT new ua.model.view.OrderView(o.id, t.number,o.status,t.id) FROM Order o JOIN o.table t")
	List<OrderView> findAllViews();

	@Query("SELECT m.title FROM Meal m  WHERE m.cafe.id=?1")
	List<String> findAllMealByCafeId(Integer id);
		
	@Query("SELECT DISTINCT o FROM Order o JOIN FETCH o.table LEFT JOIN FETCH o.meals WHERE o.id=?1")
	Order findOneRequest(Integer id);
	
	@Query("SELECT m.title FROM Meal m JOIN m.orders o WHERE o.id=?1")
	List<String> findAllMealsByOrderId(Integer id);
	
	@Query("SELECT new ua.model.view.OrderView(o.id, t.number,o.status,t.id) FROM Order o JOIN o.table t  WHERE t.cafe.id=?1 ORDER BY o.status")
	List<OrderView> findAllOrdersByCafeId(Integer id);
	
	@Query("SELECT t FROM Table t WHERE t.id=?1")
	 Table findOneTable(Integer id);
	
	@Query("SELECT o FROM Order o WHERE o.table.id=?1")
	List<Order> findAllOrderByTableId(Integer id);
	
	
}
