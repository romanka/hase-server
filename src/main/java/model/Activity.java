package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Activity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Long id;
	
	//Stats
	@ManyToOne
    @JoinColumn(name="USER_ID")
    private User user;
	
	@Column(nullable = false)
	private Integer year;
	
	@Column(nullable = false)
	private Integer month;
	
	@Column(nullable = false)
	private Integer day;
	
	@Column(nullable = false)
	private Integer hour;
	
	
	//Content
	@Column(nullable = false) 
	private Integer total;
	
	@Column(nullable = false) 
	private Boolean missing;
	
	@Column(nullable = false)
	private Integer thisHour;
	
	
	/**
	 *  Getter and Setter 
	 **/
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public Integer getDay() {
		return day;
	}

	public void setDay(Integer day) {
		this.day = day;
	}

	public Integer getHour() {
		return hour;
	}

	public void setHour(Integer hour) {
		this.hour = hour;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Boolean getMissing() {
		return missing;
	}

	public void setMissing(Boolean missing) {
		this.missing = missing;
	}

	public Integer getThisHour() {
		return thisHour;
	}

	public void setThisHour(Integer thisHour) {
		this.thisHour = thisHour;
	}

	
}
