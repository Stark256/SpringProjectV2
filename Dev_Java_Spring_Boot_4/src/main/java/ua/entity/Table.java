package ua.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Entity
@javax.persistence.Table(name="_table")
public class Table extends AbstractEntity{
	
	@ManyToOne(fetch=FetchType.LAZY)
	private OpenClose timeReserv;
	
	private String user;
	
	private int number;
	
	@Column(length=15)
	private String userPhone;

	private int countOfPeople;
	
	private boolean isFree;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Cafe cafe;

	

	public OpenClose getTimeReserv() {
		return timeReserv;
	}

	public void setTimeReserv(OpenClose timeReserv) {
		this.timeReserv = timeReserv;
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

	public Cafe getCafe() {
		return cafe;
	}

	public void setCafe(Cafe cafe) {
		this.cafe = cafe;
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

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	
	
}
