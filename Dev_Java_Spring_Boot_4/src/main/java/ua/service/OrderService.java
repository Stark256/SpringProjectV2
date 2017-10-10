package ua.service;



import java.util.List;

import ua.entity.Order;
import ua.entity.Table;
import ua.model.request.OrderRequest;
import ua.model.view.OrderView;

public interface OrderService {

	List<String> findAllMealByCafeId(Integer id);
	
	List<OrderView> findAllViews();
	
	void save(OrderRequest request);
	
	  
	  void delete(Integer id);
	  
	  OrderRequest findOne(Integer id);
	  
	  List<OrderView> findAllOrdersByCafeId(Integer id);
	  
	  Table findOneTable(Integer id);
	  
	  List<Order> findAllOrderByTableId(Integer id);
	  
	  List<String> findAllMealsByOrderId(Integer id);
	  
	  void setAccepted(Integer id);
	  
	  void setCompleted(Integer id);
	  
	  void setPaid(Integer id);
	
}
