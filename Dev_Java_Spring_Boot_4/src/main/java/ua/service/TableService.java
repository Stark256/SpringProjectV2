package ua.service;

import java.time.LocalTime;
import java.util.List;

import ua.entity.Cafe;
import ua.entity.OpenClose;
import ua.entity.Table;
import ua.model.request.TableRequest;
import ua.model.view.TableView;

public interface TableService{

  List<String> findAllCafes(String email);
  
  Cafe findOneCafeById(Integer id);
  
  List<TableView> findTableViewsByCafeId(Integer id);
  
  void save(TableRequest request);
  void saveReserv(TableRequest request);
  
  void delete(Integer id);
  
  TableRequest findOne(Integer id);
  
  List<LocalTime> findAllOpenCloses();
  
  OpenClose findOneOpenClose(Integer id);
  
  List<Table> findTablesByCafeId(Integer id);
  
  

}
