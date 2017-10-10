package ua.model.view;

import java.util.ArrayList;
import java.util.List;

import ua.entity.Status;



public class OrderView {

	private Integer id;
	
	private String status;
	
	private List<String> meals = new ArrayList<>();
	
	private Integer table;
	
	private Integer tableId;
	

	public OrderView(Integer id, int table,Status status,int tableId) {
		this.id = id;
		this.table = Integer.valueOf(table);
		this.status=status.name();
		this.tableId = tableId;
	}
	

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<String> getMeals() {
		return meals;
	}

	public void setMeals(List<String> meals) {
		this.meals = meals;
	}


	public Integer getTable() {
		return table;
	}


	public void setTable(Integer table) {
		this.table = table;
	}


	public Integer getTableId() {
		return tableId;
	}


	public void setTableId(Integer tableId) {
		this.tableId = tableId;
	}

	
	
}
