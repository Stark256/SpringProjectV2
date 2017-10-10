package ua.model.request;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

import ua.validation.annotation.UniqueOpenClose;


public class OpenCloseRequest {

	private Integer id;
	
	@NotBlank(message = "this field is required")
	@Pattern(regexp = "^(([0-9]|0[0-9]|1[0-9]|2[0-3]):[0-5][0-9])?$", message = "this value is not valid, value is not time")
	@UniqueOpenClose(message = "this time already exists in the database")
	private String time;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
}