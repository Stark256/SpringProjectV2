package ua.model.request;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

import ua.entity.Cafe;
import ua.entity.Cuisine;
import ua.entity.Ingredient;

public class MealRequest {

	private Integer id;
	
	@Pattern(regexp = "^([A-Z][a-zA-Z]+)?$", message = "value must start with a capital letter")
	@NotBlank(message = "this field is required")
	private String title;
	
	@NotBlank(message = "this field is required")
	private String description;

	@Max(value = 10000, message = "must be less than or equal to 10000")
	@Min(value = 0, message = "must be greater than or equal to 0")
	@Pattern(regexp = "^([0-9]+([,.][0-9]{1,2})?)?$", message = "this value is not valid")
	@NotBlank(message = "this field is required")
	private String price;
	
	private String photoUrl;
	
	private int version;
	
	private Cuisine cuisine;
	
	@Max(value = 1000, message = "must be less than or equal to 1000")
	@Min(value = 10, message = "must be greater than or equal to 10")
	@Pattern(regexp = "^(\\d+)?$", message = "this value is not valid")
	@NotBlank(message = "this field is required")
	private String weight;
	
	@NotEmpty(message = "may not be empty")
	private List<Ingredient> ingredients=new ArrayList<>();
	
	private Cafe cafe;

	private MultipartFile photo;
	
	
	
	public MultipartFile getPhoto() {
		return photo;
	}

	public void setPhoto(MultipartFile photo) {
		this.photo = photo;
	}

	public Cafe getCafe() {
		return cafe;
	}

	public void setCafe(Cafe cafe) {
		this.cafe = cafe;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public Cuisine getCuisine() {
		return cuisine;
	}

	public void setCuisine(Cuisine cuisine) {
		this.cuisine = cuisine;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}
	
	
	
}
