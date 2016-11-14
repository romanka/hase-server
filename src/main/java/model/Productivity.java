package model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Productivity implements Serializable {
	
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
	@Column
	private Integer percentage;
	
	@ManyToOne
	private List<Task> tasks;
	
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

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}	
	
}
