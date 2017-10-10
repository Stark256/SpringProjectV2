package ua.service;

import java.security.Principal;
import java.time.LocalTime;
import java.util.List;

import ua.entity.Cafe;
import ua.entity.Type;
import ua.entity.User;
import ua.model.request.CafeRequest;
import ua.model.view.CafeView;

public interface CafeService {
	
	//extends CrudService<Cafe, Integer>
	List<Type> findAllTypes();

	List<LocalTime> findAllOpenCloses();

	List<CafeView> findAllViews();

	void save(CafeRequest request,Principal principal,String photo);

	CafeRequest findOne(Integer id);
	
	Cafe findOneRequest(Integer id);

	void delete(Integer id);
	
	CafeRequest findOneDesc(Integer id);
	
	List<CafeView> findAllCafeByUserEmail(String email);
	
	User findOneUserByEmail(String email);
	
	void saveRate(CafeRequest request);
	
	List<Cafe> findAllCafeByTimeId(Integer id);
}
