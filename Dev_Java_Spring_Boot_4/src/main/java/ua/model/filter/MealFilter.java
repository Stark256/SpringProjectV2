package ua.model.filter;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class MealFilter {
	
	private static final Pattern DECIMAL_PATTERN = Pattern.compile("^([0-9]{1,18}\\.[0-9]{0,2})|([0-9]{1,18}\\,[0-9]{0,2})|([0-9]{1,18})$");
	
	private String minPrice = "";
	
	private String maxPrice = "";
	
	private List<Integer> cuisinesIds = new ArrayList<>();
	
	private List<Integer> ingredientsIds = new ArrayList<>();
	
	private String search = "";
	

	public String getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(String minPrice) {
		if (DECIMAL_PATTERN.matcher(minPrice).matches()) {
			this.minPrice = minPrice;
		}
	}

	public String getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(String maxPrice) {
		if (DECIMAL_PATTERN.matcher(maxPrice).matches()) {
			this.maxPrice = maxPrice;
		}
	}

	public List<Integer> getCuisinesIds() {
		return cuisinesIds;
	}

	public void setCuisinesIds(List<Integer> cuisinesIds) {
		this.cuisinesIds = cuisinesIds;
	}

	public List<Integer> getIngredientsIds() {
		return ingredientsIds;
	}

	public void setIngredientsIds(List<Integer> ingredientsIds) {
		this.ingredientsIds = ingredientsIds;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

}