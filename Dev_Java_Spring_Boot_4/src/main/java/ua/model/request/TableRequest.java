package ua.model.request;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

import ua.entity.Cafe;
import ua.entity.OpenClose;

public class TableRequest {

	private Integer id;

	//@NotBlank(message="Це поле має бути заповненим")
	private OpenClose timeReserv;

	//@NotBlank(message = "this field is required")
	//@Pattern(regexp = "^(\\[1-9]{2})?$", message = "Value must be betwen 1 to 99")
	@Max(value = 10000, message = "must be less than or equal to 100")
	@Min(value = 0, message = "must be greater than or equal to 0")
	@Pattern(regexp = "^([0-9]+([,.][0-9]{1,2})?)?$", message = "this value is not valid")
	@NotBlank(message = "this field is required")
	private String countOfPeople;

	private boolean isFree;

	//@NotBlank(message="Це поле має бути заповненим")
	private String user;

	//@NotBlank(message="Це поле має бути заповненим")
	//@Pattern(regexp = "^(\\+380[0-9]{9})?$", message = "+380XXXXXXXXX")
	private String userPhone;

	private Cafe cafe;
	
	//@NotBlank(message = "this field is required")
	//@Pattern(regexp = "^(\\[1-9]{2})?$", message = "Value must be betwen 1 to 99")
	@Max(value = 10000, message = "must be less than or equal to 100")
	@Min(value = 0, message = "must be greater than or equal to 0")
	@Pattern(regexp = "^([0-9]+([,.][0-9]{1,2})?)?$", message = "this value is not valid")
	@NotBlank(message = "this field is required")
	private String number;

	public OpenClose getTimeReserv() {
		return timeReserv;
	}

	public void setTimeReserv(OpenClose timeReserv) {
		this.timeReserv = timeReserv;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public boolean getIsFree() {
		return isFree;
	}

	public void setIsFree(boolean isFree) {
		this.isFree = isFree;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public Cafe getCafe() {
		return cafe;
	}

	public void setCafe(Cafe cafe) {
		this.cafe = cafe;
	}

	public String getCountOfPeople() {
		return countOfPeople;
	}

	public void setCountOfPeople(String countOfPeople) {
		this.countOfPeople = countOfPeople;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	
	
}
