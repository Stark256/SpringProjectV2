package ua.service.impl;



import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.entity.CafeComment;
import ua.model.request.CafeCommentRequest;
import ua.repository.CafeCommentRepository;
import ua.repository.CafeRepository;
import ua.service.CafeCommentService;

@Service
public class CafeCommentServiceImpl  implements CafeCommentService{

	private final CafeCommentRepository repository;
	
	private final CafeRepository cafeRepository;
	

	@Autowired
	public CafeCommentServiceImpl(CafeCommentRepository repository,CafeRepository cafeRepository) {
		this.repository = repository;
		this.cafeRepository=cafeRepository;
	}

	@Override
	public List<CafeComment> findAllCommentByCafe(Integer id) {
		List<CafeComment> commentSort=new ArrayList<>();
		List<CafeComment> comments=repository.findAllCommentByCafe(id);
		for (CafeComment cafeComment : comments) {
			commentSort.add(cafeComment);
			List<CafeComment> parentComment=repository.findAllParentCommentByCommentId(cafeComment.getId());
			if(!parentComment.isEmpty()){
				for (CafeComment parComment : parentComment) {
					commentSort.add(parComment);
				}
			}
		}
		
		return commentSort;
	}


	@Override
	public void saveComment(CafeCommentRequest commentRequest, Integer id) {
		CafeComment comment = new CafeComment();
		comment.setComment(commentRequest.getComment());
		comment.setUser(commentRequest.getUser());
		comment.setRate(commentRequest.getRate());
		comment.setTime(LocalDateTime.now());
		comment.setCafe(cafeRepository.findOne(id));
		comment.setParentComment(commentRequest.getParentComment());
		repository.save(comment);		
	}

	@Override
	public List<CafeComment> findCommentByCafeId(Integer id) {
		return repository.findCommentByCafeId(id);
	}

	@Override
	public CafeCommentRequest findOne(Integer id) {
		CafeComment comment=repository.findOne(id);
		CafeCommentRequest request=new CafeCommentRequest();
		request.setId(comment.getId());
		request.setParentComment(comment.getParentComment());
		request.setRate(comment.getRate());
		request.setUser(comment.getUser());
		request.setCafe(comment.getCafe());
		request.setComment(comment.getComment());
		return request;
	}
	
	@Override
	public void saveCommentOnComment(CafeCommentRequest commentRequest, Integer id,Integer cafeId) {
		CafeComment comment = new CafeComment();
		comment.setComment(commentRequest.getComment());
		comment.setUser(commentRequest.getUser());
		comment.setRate(commentRequest.getRate());
		comment.setTime(LocalDateTime.now());
		comment.setCafe(cafeRepository.findOne(cafeId));
		comment.setParentComment(repository.findOne(id));
		repository.save(comment);		
	}
	
	@Override
	public CafeComment findOneComment(Integer id) {
		return repository.findOne(id);
	}
	
	
	

}
