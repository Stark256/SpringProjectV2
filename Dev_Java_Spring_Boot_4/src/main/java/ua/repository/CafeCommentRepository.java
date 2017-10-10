package ua.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ua.entity.CafeComment;
import ua.model.view.CafeCommentView;

public interface CafeCommentRepository extends JpaRepository<CafeComment, Integer> {

	@Query("SELECT new ua.model.view.CafeCommentView(comment.id,comment.comment,  comment.user,comment.time, comment.rate) FROM CafeComment comment JOIN comment.cafe cafe WHERE cafe.id=?1")
	List<CafeCommentView> findAllCommentByCafeId(Integer id);
	
	@Query("SELECT c FROM CafeComment c JOIN c.cafe cafe  WHERE cafe.id=?1")
	List<CafeComment> findCommentByCafeId(Integer id);
	
	@Query("SELECT c FROM CafeComment c JOIN c.cafe cafe  WHERE cafe.id=?1 AND c.parentComment=null")
	List<CafeComment> findAllCommentByCafe(Integer id);
	
	@Query("SELECT c FROM CafeComment c WHERE c.parentComment.id=?1")
	List<CafeComment> findAllParentCommentByCommentId(Integer id);
}
//JOIN comment.cafe cafe