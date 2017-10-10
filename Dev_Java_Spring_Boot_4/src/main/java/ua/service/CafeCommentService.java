package ua.service;

import java.util.List;

import ua.entity.CafeComment;
import ua.model.request.CafeCommentRequest;

public interface CafeCommentService{



	void saveComment(CafeCommentRequest commentRequest, Integer id);
	
	void saveCommentOnComment(CafeCommentRequest commentRequest, Integer id,Integer cafeId);
	
	List<CafeComment> findCommentByCafeId(Integer id);
	
	List<CafeComment> findAllCommentByCafe(Integer id);
	
	CafeCommentRequest findOne(Integer id);
	
	CafeComment findOneComment(Integer id);
}
