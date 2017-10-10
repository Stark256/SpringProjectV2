package ua.service;

import java.time.LocalTime;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.entity.OpenClose;
import ua.model.filter.SimpleFilter;
import ua.model.request.OpenCloseRequest;

public interface OpenCloseService {

List<LocalTime> findAllTimes();
	
	Page<OpenClose> findAll(Pageable pageable, SimpleFilter filter);

	void save(OpenCloseRequest request);
	
	OpenCloseRequest findOneRequest(Integer id);

	void delete(Integer id);
	
}
