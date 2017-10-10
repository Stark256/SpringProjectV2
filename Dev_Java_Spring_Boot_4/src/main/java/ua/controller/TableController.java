package ua.controller;




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

import ua.entity.Order;
import ua.model.request.TableRequest;
import ua.service.OrderService;
import ua.service.TableService;

@Controller
@RequestMapping("/profile/cafe")
@SessionAttributes("_table")
public class TableController {

  private final TableService service;
  
  private final OrderService orderService;
  
  
  @Autowired
  public TableController(TableService service,OrderService orderService) {
    this.service = service;
    this.orderService = orderService;
  }
  
  @ModelAttribute("_table")
  public TableRequest getForm() {
    return new TableRequest();
  }
  
  @GetMapping("/addtable/{id}")
  public String show(Model model, @PathVariable Integer id) {
    model.addAttribute("tables", service.findTableViewsByCafeId(id));
    model.addAttribute("cafeId", id);
    return "addtable";
  }
  
  @GetMapping("/addtable/{id}/delete/{tableId}")
  public String delete(@PathVariable Integer id,@PathVariable Integer tableId) {
	  
	  List<Order> orders=orderService.findAllOrderByTableId(tableId);
	  for (Order order2 : orders) {
		  orderService.delete(order2.getId());
	  }
	 service.delete(tableId);
    return "redirect:/profile/cafe/addtable/{id}";
  }
  
  @PostMapping("/addtable/{id}")
  public String save(@ModelAttribute("_table") @Valid TableRequest request,BindingResult br,Model model,  SessionStatus status, @PathVariable Integer id) {
	 /* if(request.getNumber()==null||request.getCountOfPeople()==null){
		  if(request.getNumber()==null)model.addAttribute("emptyNumber",true);
		  if(request.getCountOfPeople()==null)model.addAttribute("emptyChairs",true);
		  return show(model,id);
	  }*/
	  if(br.hasErrors()){
		  return show(model,id);
	  }
	  request.setIsFree(true);
    request.setUser(null);
    request.setUserPhone(null);
    request.setTimeReserv(service.findOneOpenClose(1));
    request.setCafe(service.findOneCafeById(id));
    service.save(request);
    return cancel(status);
  }
  
  @GetMapping("/addtable/{id}/cancel")
  public String cancel(SessionStatus status) {
    status.setComplete();
    return "redirect:/profile/cafe/addtable/{id}";
  }
  
  @GetMapping("/addtable/{id}/reserve/{tableId}")
  public String reserve(@PathVariable Integer id,@PathVariable Integer tableId, Model model) {
    model.addAttribute("_table", service.findOne(tableId));
    model.addAttribute("times", service.findAllOpenCloses());
    model.addAttribute("cafeId", id);
    return "reserve";
  } 
  
  @PostMapping("/addtable/{id}/reserve/{tableId}")
  public String reserveSave(@ModelAttribute("_table") TableRequest request,Model model, @PathVariable Integer id, @PathVariable Integer tableId) {
	 /* if(request.getUser().isEmpty()||request.getUserPhone().isEmpty()){
		  if(request.getUser().isEmpty())model.addAttribute("emptyName",true);
		  if(request.getUserPhone().isEmpty())model.addAttribute("emptyPhone",true);
		  return reserve(id,tableId,model);
	  }*/
	  if(request.getUser().isEmpty()){
	  model.addAttribute("emptyName",true);
		  return reserve(id,tableId,model);
	  }
	 
	  request.setId(tableId);
  request.setIsFree(false);
  System.out.println(request.getId());
  service.saveReserv(request);
    return "redirect:/profile/cafe/addtable/{id}";
  } 
  
 
  @GetMapping("/addtable/{id}/unbook/{tableId}")
  public String dereserve( @PathVariable Integer id, @PathVariable Integer tableId) {
	  TableRequest request=service.findOne(tableId);
    System.out.println(request.getId());
    request.setIsFree(true);
    request.setUser(null);
    request.setUserPhone(null);
    request.setTimeReserv(service.findOneOpenClose(1));
     service.saveReserv(request);
    return "redirect:/profile/cafe/addtable/{id}";
  }
  
 
  
}