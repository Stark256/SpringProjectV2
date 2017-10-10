package ua.entity;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

import ua.validation.annotation.UniqueCuisine;
import ua.validation.annotation.UniqueIngredient;


@MappedSuperclass
public abstract class AbstractEntityName extends AbstractEntity{
	
	@UniqueIngredient(message="The ingredient alredy exist")
	@UniqueCuisine(message="The cuisine alredy exist")
	@NotBlank(message="This field must be filled")
	@Pattern(regexp = "^[A-Z][a-zA-Z0-9]+| *$", message="The name should begin with a capital letter")
	private String name;

	public AbstractEntityName() {
	}

	public AbstractEntityName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}