package ua.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="cafe_comment")
public class CafeComment extends AbstractEntity{
	
	@Lob
	private String comment;
	
	private String user;
	
	private BigDecimal rate;
	
	private LocalDateTime time;
	
	@ManyToOne
	private CafeComment parentComment;
	
	@OneToMany(mappedBy="parentComment")
	private List<CafeComment> childComment = new ArrayList<CafeComment>();
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Cafe cafe;

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

	public Cafe getCafe() {
		return cafe;
	}

	public void setCafe(Cafe cafe) {
		this.cafe = cafe;
	}

	public BigDecimal getRate() {
		return rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

	public CafeComment getParentComment() {
		return parentComment;
	}

	public void setParentComment(CafeComment parentComment) {
		this.parentComment = parentComment;
	}

	public List<CafeComment> getChildComment() {
		return childComment;
	}

	public void setChildComment(List<CafeComment> childComment) {
		this.childComment = childComment;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}
	
	
	
}
