package ua.model.request;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

public class RegistrationRequest {
	
	
	@NotBlank(message="This field must be filled")
	//@Pattern(regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")
	@Pattern(regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", message = "Bad Email")
	//@Pattern(regexp = "^[a-zA-Z0-9]+]| *$", message="Назва має починатись з великої букви")
	private String email;
	
	@NotBlank(message="This field must be filled")
	@Size(min = 6, max = 15, message = "The password must be between 6 and 15 characters")
	private String password;
	
	@NotBlank(message="This field must be filled")
	private String repeatPassword;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRepeatPassword() {
		return repeatPassword;
	}

	public void setRepeatPassword(String repeatPassword) {
		this.repeatPassword = repeatPassword;
	}
}
