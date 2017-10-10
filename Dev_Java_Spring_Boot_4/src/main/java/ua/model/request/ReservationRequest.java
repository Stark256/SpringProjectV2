package ua.model.request;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

import ua.entity.Cafe;
import ua.entity.OpenClose;

public class ReservationRequest {
	private Integer id;

	@NotBlank(message="Це поле має бути заповненим")
	private OpenClose timeReserv;

	//@NotNull(message="Це поле має бути заповненим")
	private Integer countOfPeople;

	private boolean isFree;

	@NotBlank(message="Це поле має бути заповненим")
	private String user;

	@NotBlank(message="Це поле має бути заповненим")
	@Pattern(regexp = "^(\\+380[0-9]{9})?$", message = "+380XXXXXXXXX")
	private String userPhone;

	private Cafe cafe;
	
	//@NotNull(message="Це поле має бути заповненим")
	private Integer number;

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

	public Integer getCountOfPeople() {
		return countOfPeople;
	}

	public void setCountOfPeople(Integer countOfPeople) {
		this.countOfPeople = countOfPeople;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}
	
}
