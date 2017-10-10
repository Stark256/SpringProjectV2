package ua.service.impl;

import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.entity.Cafe;
import ua.entity.OpenClose;
import ua.entity.Table;
import ua.model.request.TableRequest;
import ua.model.view.TableView;
import ua.repository.TableRepository;
import ua.service.TableService;

@Service
public class TableServiceImpl implements TableService {
 
	private final TableRepository repository;

  @Autowired
  public TableServiceImpl(TableRepository repository) {
    this.repository = repository;
  }

  @Override
  public List<String> findAllCafes(String email) {
    return repository.findAllCafe(email);
  }

  @Override
  public List<TableView> findTableViewsByCafeId(Integer id) {
    return repository.findTableViewsByCafeId(id);
  }

  @Override
  public Cafe findOneCafeById(Integer id) {
    return repository.findCafeById(id);
  }

  @Override
  public void saveReserv(TableRequest request) {
    Table table = new Table();
    table.setId(request.getId());
    table.setNumber(Integer.valueOf(request.getNumber()));
    table.setTimeReserv(request.getTimeReserv());
    table.setCountOfPeople(Integer.valueOf(request.getCountOfPeople()));
    table.setUser(request.getUser());
    table.setUserPhone(request.getUserPhone());
    table.setIsFree(request.getIsFree());
    table.setCafe(request.getCafe());
    repository.save(table);
  }
  @Override
  public void save(TableRequest request) {
	  Table table = new Table();
	  //  table.setId(request.getId());
	  	table.setNumber(Integer.valueOf(request.getNumber()));
	    table.setTimeReserv(request.getTimeReserv());
	    table.setCountOfPeople(Integer.valueOf(request.getCountOfPeople()));
	    table.setUser(request.getUser());
	    table.setUserPhone(request.getUserPhone());
	    table.setIsFree(request.getIsFree());
	    table.setCafe(request.getCafe());
	    repository.save(table);
  }

  @Override
  public void delete(Integer id) {
    repository.delete(id);
  }

  @Override
  public TableRequest findOne(Integer id) {
    Table table = repository.findOne(id);
    TableRequest request = new TableRequest();
    request.setId(table.getId());
    request.setNumber(Integer.valueOf(table.getNumber()).toString());
    request.setTimeReserv(table.getTimeReserv());
    request.setCountOfPeople(Integer.valueOf(table.getCountOfPeople()).toString());
    request.setUser(table.getUser());
    request.setUserPhone(table.getUserPhone());
    request.setIsFree(table.getIsFree());
    request.setCafe(table.getCafe());
    return request;
  }
  

@Override
public List<LocalTime> findAllOpenCloses() {
	return repository.findAllOpenClose();
}

@Override
public OpenClose findOneOpenClose(Integer id) {
	return repository.findOneOpenClose(id);
}

@Override
public List<Table> findTablesByCafeId(Integer id) {
	return repository.findTablesByCafeId(id);
}





}