package ua.service.impl;

import java.time.LocalTime;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import ua.entity.OpenClose;
import ua.entity.OpenClose_;
import ua.model.filter.SimpleFilter;
import ua.model.request.OpenCloseRequest;
import ua.repository.OpenCloseRepository;
import ua.service.OpenCloseService;

@Service
public class OpenCloseServiceImpl  implements OpenCloseService{

	@Autowired
	private OpenCloseRepository repository;

	@Override
	public List<LocalTime> findAllTimes() {
		return repository.findAllTimes();
	}

	@Override
	public Page<OpenClose> findAll(Pageable pageable, SimpleFilter filter) {
		return repository.findAll(filter(filter), pageable);
	}
	
	private Specification<OpenClose> filter(SimpleFilter filter) {
		return (root, query, cb) -> {
			if (filter.getSearch().isEmpty()) {
				return null;
			}
			Pattern pattern = Pattern.compile("^([0-9]|0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]$");
			Matcher matcher = pattern.matcher(filter.getSearch());
			if (!matcher.matches()) {
				return null;
			}
			pattern = Pattern.compile("^[0-9]:[0-5][0-9]$");
			matcher = pattern.matcher(filter.getSearch());
			return cb.equal(root.get(OpenClose_.time), LocalTime.parse(matcher.matches() ? "0" + filter.getSearch() : filter.getSearch()));
		};
	}

	@Override
	public void save(OpenCloseRequest request) {
		OpenClose time = new OpenClose();
		time.setId(request.getId());
		Pattern pattern = Pattern.compile("^[0-9]:[0-5][0-9]$");
		Matcher matcher = pattern.matcher(request.getTime());
		time.setTime(LocalTime.parse(matcher.matches() ? "0" + request.getTime() : request.getTime()));
		repository.save(time);
	}

	@Override
	public OpenCloseRequest findOneRequest(Integer id) {
		OpenClose time = repository.findOne(id);
		OpenCloseRequest request = new OpenCloseRequest();
		request.setId(time.getId());
		request.setTime(String.valueOf(time.getTime()));
		return request;
	}

	@Override
	public void delete(Integer id) {
		repository.delete(id);
	}

}
