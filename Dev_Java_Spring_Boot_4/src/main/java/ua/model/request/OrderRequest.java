package ua.model.request;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.constraints.NotBlank;

import ua.entity.Meal;

public class OrderRequest {
	
	private Integer id;
	
	private String status;
	
	@NotBlank(message="Це поле має бути заповненим")
	private List<Meal> meals = new ArrayList<>();
	
	private ua.entity.Table table;

	public List<Meal> getMeals() {
		return meals;
	}

	public void setMeals(List<Meal> meals) {
		this.meals = meals;
	}

	public ua.entity.Table getTable() {
		return table;
	}

	public void setTable(ua.entity.Table table) {
		this.table = table;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
