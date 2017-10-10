package ua.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import ua.model.request.TableRequest;
import ua.service.TableService;

@Controller
@RequestMapping("/clientRes")
@SessionAttributes("_table")
public class ClientTableController {

	
	private final TableService service;
	  
	  @Autowired
	  public ClientTableController(TableService service) {
	    this.service = service;
	  }
	  
	  
	
	@GetMapping("/addtable/{id}/client")
	  public String showForClient(Model model, @PathVariable Integer id) {
	    model.addAttribute("tables", service.findTableViewsByCafeId(id));
	    model.addAttribute("times", service.findAllOpenCloses());
	    model.addAttribute("cafeId", id);
	    return "clientTable";
	  }
	  
	  @GetMapping("/addtable/{id}/client/{tableId}")
	  public String reserveClient(@PathVariable Integer id,@PathVariable Integer tableId, Model model) {
	    model.addAttribute("_table", service.findOne(tableId));
	    model.addAttribute("times", service.findAllOpenCloses());
	    model.addAttribute("cafeId", id);
	   // model.addAttribute("tableId", tableId);
	    
	    return "clientReserv";
	  } 
	  
	 /* @ModelAttribute("_table")
	  public TableRequest getForm() {
	    return new TableRequest();
	  }*/
	  
	  @PostMapping("/addtable/{id}/client/{tableId}")
	  public String reserveSaveClient(@ModelAttribute("_table") TableRequest request, @PathVariable Integer id, @PathVariable Integer tableId, Model model) {
		  if(request.getUser().isEmpty()){
			  model.addAttribute("emptyName",true);
			  return reserveClient(id,tableId,model);
		  }
		  request.setId(tableId);
	  request.setIsFree(false);
	  System.out.println(request.getId());
	  service.saveReserv(request);
	    return "redirect:/cafedesc/{id}";
	  } 
}
