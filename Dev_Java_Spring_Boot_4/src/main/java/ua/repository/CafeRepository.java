package ua.repository;

import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import ua.entity.Cafe;
import ua.entity.CafeComment;
import ua.entity.OpenClose;
import ua.entity.User;
import ua.model.view.CafeView;

public interface CafeRepository extends JpaNameRepository<Cafe>, JpaSpecificationExecutor<Cafe>{
	
	@Query("SELECT DISTINCT oc FROM OpenClose oc WHERE oc.time=?1")
	OpenClose findByTime(LocalTime time);
	
	@Query("SELECT new ua.model.view.CafeView(c.id, c.rate, c.name, c.photoUrl, c.version, c.address,c.fullDescription,c.shortDescription, c.type, c.phone, op.time, cl.time) FROM Cafe c JOIN c.open op JOIN c.close cl")
	List<CafeView> findAllViews();
	
	@Query("SELECT t.time FROM OpenClose t")
	List<LocalTime> findAllOpenClose();
	
	@Query("SELECT DISTINCT c FROM Cafe c JOIN FETCH c.open JOIN FETCH c.close WHERE c.id=?1")
	Cafe findOneRequest(Integer id);
	
	@Query("SELECT  c FROM Cafe c JOIN FETCH c.open JOIN FETCH c.close WHERE c.id=?1")
	Cafe findOneDesc(Integer id);
	
	@Query("SELECT u FROM User u WHERE u.email=?1")
	User findOneUserByEmail(String email);
	
	@Query("SELECT new ua.model.view.CafeView(c.id, c.rate, c.name, c.photoUrl, c.version, c.address,c.fullDescription,c.shortDescription, c.type, c.phone, op.time, cl.time) FROM Cafe c JOIN c.open op JOIN c.close cl WHERE c.user.email=?1")
	List<CafeView> findAllCafeByUserEmail(String email);
	
	@Query("SELECT cc FROM CafeComment cc WHERE cc.cafe.id=?1")
	List<CafeComment> findAllComentByCafeId(Integer id);
	
	@Query("SELECT c FROM Cafe c WHERE c.open.id=?1 OR c.close.id=?1")
	List<Cafe> findAllCafeByTimeId(Integer id);
}
