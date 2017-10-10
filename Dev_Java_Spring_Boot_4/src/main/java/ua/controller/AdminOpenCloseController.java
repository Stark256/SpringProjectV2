package ua.controller;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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

import ua.com.model.bilder.BuilderParams;
import ua.entity.OpenClose;
import ua.model.filter.SimpleFilter;
import ua.model.request.OpenCloseRequest;
import ua.service.OpenCloseService;

@Controller
@RequestMapping("/admin/time")
@SessionAttributes("time")
public class AdminOpenCloseController {
	
private final OpenCloseService service;

	
	@Autowired
	public AdminOpenCloseController(OpenCloseService service) {
		this.service=service;
	}
	
	/*@GetMapping
	public String show(Model model) {
		model.addAttribute("times",service.findAll());
		return "time";
	}*/
	
	@ModelAttribute("filter")
	public SimpleFilter getFilter() {
		return new SimpleFilter();
	}
	
	@GetMapping
	public String show(Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter")  SimpleFilter filter, BindingResult bindingResult) {
		model.addAttribute("times", service.findAll(pageable, filter));
		return "time";
	}
	
	@ModelAttribute("time")
	public OpenClose getForm(){
		return new OpenClose();
	}
	
	/*@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id) {
		service.delete(id);
		return "redirect:/admin/time";
	}*/
	
	@GetMapping("time/{id}/delete")
	public String delete(@PathVariable Integer id, @PageableDefault Pageable pageable, @ModelAttribute("filter") SimpleFilter filter) {
		service.delete(id);
		return "redirect:/admin/time" + BuilderParams.buildParams(pageable, filter);
	}
	
	/*@GetMapping("cancel")
	public String cancel(SessionStatus status){
		status.setComplete();
		return "redirect:/admin/time";
	}*/
	@GetMapping("/cancel")
	public String cancel(SessionStatus status, @PageableDefault Pageable pageable, @ModelAttribute("filter") SimpleFilter filter) {
		status.setComplete();
		return "redirect:/admin/time" + BuilderParams.buildParams(pageable, filter);
	}
/*	@GetMapping("/update/{id}")
	public String update(@PathVariable Integer id,Model model){
		model.addAttribute("time",service.findOne(id));
		return show(model);
	}*/
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable Integer id, Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") SimpleFilter filter, BindingResult bindingResult) {
		model.addAttribute("time", service.findOneRequest(id));
		return show(model, pageable, filter, bindingResult);
	}
	
	/*@PostMapping
	public String save(@ModelAttribute("time") OpenClose openClose,Model model,SessionStatus status) {
		List<OpenClose> times=service.findAll();
		boolean unique=false;
		for (OpenClose openClose2 : times) {
			if(openClose.getTime().equals(openClose2.getTime())){
				unique=true;
			}
		}
		if(unique){
			model.addAttribute("notUnique", true);
			return show(model);
		}
		service.save(openClose);
		return cancel(status);
	}*/
	@PostMapping
	public String save(@ModelAttribute("time") @Valid OpenCloseRequest request, BindingResult bindingResult, Model model, SessionStatus status, @PageableDefault Pageable pageable, @ModelAttribute("filter") SimpleFilter filter) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("isErrors", true);
			return show(model, pageable, filter, bindingResult);
		}
		service.save(request);
		return cancel(status, pageable, filter);
	}
}
