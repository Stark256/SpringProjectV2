package ua.model.view;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TableView {

	private Integer id;

	private int countOfPeople;

	private boolean isFree;

	private String user;

	private String userPhone;

	private String cafe;

	private String timeReserv;

	private int number;

	public TableView(Integer id, int countOfPeople, boolean isFree, String user, String userPhone, String cafe,
			LocalTime timeReserv, int number) {
		this.id = id;
		this.countOfPeople = countOfPeople;
		this.isFree = isFree;
		this.user = user;
		this.userPhone = userPhone;
		this.cafe = cafe;
		this.timeReserv = timeReserv.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
		this.number = number;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getTimeReserv() {
		return timeReserv;
	}

	public void setTimeReserv(String timeReserv) {
		this.timeReserv = timeReserv;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getCountOfPeople() {
		return countOfPeople;
	}

	public void setCountOfPeople(int countOfPeople) {
		this.countOfPeople = countOfPeople;
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

	public String getCafe() {
		return cafe;
	}

	public void setCafe(String cafe) {
		this.cafe = cafe;
	}

}
