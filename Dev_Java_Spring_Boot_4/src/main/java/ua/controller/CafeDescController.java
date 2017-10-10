package ua.controller;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import ua.entity.Cafe;
import ua.entity.CafeComment;
import ua.model.request.CafeCommentRequest;
import ua.model.request.CafeRequest;
import ua.repository.CafeRepository;
import ua.service.CafeCommentService;
import ua.service.CafeIndexService;
import ua.service.CafeService;

@Controller
@RequestMapping("/cafedesc")
@SessionAttributes("comment")
public class CafeDescController {

private final CafeRepository repository;
private final CafeService service;
private final CafeIndexService indexService;
private final CafeCommentService commentService;
	
	@Autowired
	public CafeDescController(CafeService service,CafeIndexService indexService,CafeCommentService commentService,CafeRepository repository) {
		this.service = service;
		this.indexService=indexService;
		this.commentService=commentService;
		this.repository=repository;
	}
	
	@GetMapping("/{id}")
	public String desc(@PathVariable Integer id, Model model){
		model.addAttribute("cafe", service.findOne(id));
		model.addAttribute("meals", indexService.findMealByCafeId(id));
		model.addAttribute("comments", commentService.findAllCommentByCafe(id));
		return "cafedesc";
	}
	
	@PostMapping("/{id}")
	public String saveComment(@ModelAttribute("comment") @Valid CafeCommentRequest commentRequest,BindingResult br,@PathVariable Integer id, SessionStatus status,Model model) {
		/*if(commentRequest.getUser().isEmpty()||commentRequest.getComment().isEmpty()){
			if(commentRequest.getUser().isEmpty()) model.addAttribute("emptyUser",true);
			if(commentRequest.getComment().isEmpty()) model.addAttribute("emptyComment",true);
			return desc(id, model);
		}*/
		
		if(br.hasErrors()){
			return desc(id, model);
		}
		
		if(commentRequest.getRate()!=null){
			List<CafeComment> comment=commentService.findCommentByCafeId(id);
			if(!comment.isEmpty()){
				BigDecimal rate=BigDecimal.ZERO;
				int count=0;
			for (CafeComment cafeComment : comment) {
				if(cafeComment.getRate()!=null){
					rate=rate.add(cafeComment.getRate());
					count++;
				}
			}
			CafeRequest request=service.findOne(id);
			request.setRate(rate.divide(new BigDecimal(count), 2, RoundingMode.HALF_UP));
			service.saveRate(request);
			}else{
				CafeRequest request=service.findOne(id);
				request.setRate(commentRequest.getRate());
				service.saveRate(request);
			}
			
		}
		commentService.saveComment(commentRequest, id);
		return cancel(status);
}
	
	@PostMapping("/{id}/tocomment/{commentId}")
	public String saveCommentComment(@ModelAttribute("comment") @Valid CafeCommentRequest commentRequest,BindingResult br,@PathVariable Integer id,@PathVariable Integer commentId, SessionStatus status,Model model) {
		/*if(commentRequest.getUser().isEmpty()||commentRequest.getComment().isEmpty()){
			if(commentRequest.getUser().isEmpty()) model.addAttribute("emptyUser",true);
			if(commentRequest.getComment().isEmpty()) model.addAttribute("emptyComment",true);
			return showCommentToComment(id,commentId, model);
		}*/
		if(br.hasErrors()){
			return showCommentToComment(id,commentId, model);
		}
		/*if(commentRequest.getRate()!=null){
			List<CafeComment> comment=commentService.findCommentByCafeId(id);
			BigDecimal rate=BigDecimal.ZERO;
			int count=0;
			for (CafeComment cafeComment : comment) {
				if(cafeComment.getRate()!=null){
					rate=rate.add(cafeComment.getRate());
					count++;
				}
			}
			CafeRequest request=service.findOne(id);
			request.setRate(rate.divide(new BigDecimal(count)));
			service.saveRate(request);
		}*/
		commentService.saveCommentOnComment(commentRequest, commentId,id);
		return cancel(status);
	}
	
	@GetMapping("/{id}/tocomment/{commentId}")
	public String showCommentToComment(@PathVariable Integer id,@PathVariable Integer commentId, Model model){
		//model.addAttribute("comment", commentService.findOne(id));
		model.addAttribute("cafe", service.findOneRequest(id));
		model.addAttribute("commentId", commentId);
		return "comtocom";
	}
	
	@ModelAttribute("comment")
	public CafeCommentRequest getFormComment() {
		return new CafeCommentRequest();
	}
	
	@GetMapping("/{id}/cancel")
	public String cancel(SessionStatus status) {
		status.setComplete();
		return "redirect:/cafedesc/{id}";
	}	
	
}
