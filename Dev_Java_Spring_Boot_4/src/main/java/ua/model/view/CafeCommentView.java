package ua.model.view;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CafeCommentView {

	private Integer id;
	
	private String comment;
	
	private String time;
	
	private String user;
	
	
	private BigDecimal rate;

	public CafeCommentView(Integer id,String comment, String user, LocalDateTime time,BigDecimal rate) {
		super();
		this.id=id;
		this.comment = comment;
		this.user = user;
		this.time = time.format(DateTimeFormatter.ofPattern("HH:mm dd/MM/yyyy"));
		this.rate=rate;
	}
	
	
	
	public String getTime() {
		return time;
	}



	public void setTime(String time) {
		this.time = time;
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public BigDecimal getRate() {
		return rate;
	}



	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}



	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

 	
	
}
