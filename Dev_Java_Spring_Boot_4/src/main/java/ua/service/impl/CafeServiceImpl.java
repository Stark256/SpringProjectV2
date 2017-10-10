package ua.service.impl;

import java.math.BigDecimal;
import java.security.Principal;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


import org.springframework.stereotype.Service;

import ua.entity.Cafe;
import ua.entity.Type;
import ua.entity.User;
import ua.model.request.CafeRequest;
import ua.model.view.CafeView;
import ua.repository.CafeRepository;
import ua.service.CafeService;

@Service
public class CafeServiceImpl   implements CafeService {

	private final CafeRepository repository;


	
	
	public CafeServiceImpl(CafeRepository repository) {
		this.repository = repository;
	}


	@Override
	public List<LocalTime> findAllOpenCloses() {
		return repository.findAllOpenClose();
	}


	@Override
	public List<CafeView> findAllViews() {
		return repository.findAllViews();
	}


	@Override
	public void save(CafeRequest request,Principal principal,String photo) {
		Cafe cafe=new Cafe();
		cafe.setId(request.getId());
		cafe.setName(request.getName());
		cafe.setRate(new BigDecimal(0));
		cafe.setShortDescription(request.getShortDescription());
		cafe.setAddress(request.getAddress());
		cafe.setVersion(request.getPhotoUrl() != null && request.getPhotoUrl().equals(photo) ? request.getVersion() + 1 : 0);
		cafe.setFullDescription(request.getFullDescription());
		cafe.setType(Type.valueOf(request.getType()));
		if(request.getPhone().length()<14)
		cafe.setPhone(request.getPhone());
		cafe.setOpen(repository.findByTime(request.getOpen()));
		cafe.setClose(repository.findByTime(request.getClose()));
		cafe.setUser(repository.findOneUserByEmail(principal.getName()));
		cafe.setPhotoUrl(photo);
		repository.save(cafe);
	}


	@Override
	public List<Type> findAllTypes() {
		List<Type> types=new ArrayList<>();
		for(int i=0;i<Type.values().length;i++){
			types.add(Type.values()[i]);
		}
		return types;
	}



	@Override
	public CafeRequest findOne(Integer id) {
		Cafe cafe=repository.findOne(id);
		CafeRequest request = new CafeRequest();
		request.setId(cafe.getId());
		request.setName(cafe.getName());
		request.setRate(cafe.getRate());
		request.setPhotoUrl(cafe.getPhotoUrl());
		request.setAddress(cafe.getAddress());
		request.setVersion(cafe.getVersion());
		request.setFullDescription(cafe.getFullDescription());
		request.setShortDescription(cafe.getShortDescription());
		request.setType(String.valueOf(cafe.getType()));
		request.setPhone(cafe.getPhone());
		request.setOpen(cafe.getOpen().getTime());
		request.setClose(cafe.getClose().getTime());
		return request;
	}


	@Override
	public void delete(Integer id) {
		repository.delete(id);
	}


	@Override
	public CafeRequest findOneDesc(Integer id) {
		Cafe cafe=repository.findOneDesc(id);
		CafeRequest request = new CafeRequest();
		request.setId(cafe.getId());
		request.setName(cafe.getName());
		request.setRate(cafe.getRate());
		request.setPhotoUrl(cafe.getPhotoUrl());
		request.setAddress(cafe.getAddress());
		request.setVersion(cafe.getVersion());
		request.setFullDescription(cafe.getFullDescription());
		request.setShortDescription(cafe.getShortDescription());
		request.setType(String.valueOf(cafe.getType()));
		request.setPhone(cafe.getPhone());
		request.setOpen(cafe.getOpen().getTime());
		request.setClose(cafe.getClose().getTime());
		return request;
	}


	@Override
	public List<CafeView> findAllCafeByUserEmail(String email) {
		return repository.findAllCafeByUserEmail(email);
	}


	@Override
	public User findOneUserByEmail(String email) {
		return repository.findOneUserByEmail(email);
	}


	@Override
	public Cafe findOneRequest(Integer id) {
		return repository.findOneRequest(id);
	}


	@Override
	public void saveRate(CafeRequest request) {
		Cafe cafe=repository.findOne(request.getId());
		cafe.setRate(request.getRate());
		repository.save(cafe);
	}


	@Override
	public List<Cafe> findAllCafeByTimeId(Integer id) {
		return repository.findAllCafeByTimeId(id);
	}


	
}



	
