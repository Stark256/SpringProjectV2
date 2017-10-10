package ua.repository;

import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ua.entity.Cafe;
import ua.entity.OpenClose;
import ua.entity.Table;
import ua.model.view.TableView;

public interface TableRepository extends JpaRepository<Table,Integer> {
  
  @Query("SELECT c.name FROM Cafe c WHERE c.user.email=?1")
  List<String> findAllCafe(String email);
  
  @Query("SELECT c FROM Cafe c WHERE c.id=?1")
  Cafe findCafeById(Integer id);
  
  @Query("SELECT new ua.model.view.TableView(t.id, t.countOfPeople, t.isFree, t.user, t.userPhone, c.name, op.time,t.number) FROM Table t JOIN t.cafe c JOIN t.timeReserv op WHERE c.id=?1 ORDER BY t.isFree DESC")
  List<TableView> findTableViewsByCafeId(Integer id);

  @Query("SELECT op.time FROM OpenClose op")
	List<LocalTime> findAllOpenClose();
  
  @Query("SELECT op FROM OpenClose op WHERE op.id=?1")
 	OpenClose findOneOpenClose(Integer id);
  
  @Query("SELECT t FROM Table t  WHERE t.cafe.id=?1")
  List<Table> findTablesByCafeId(Integer id);
}