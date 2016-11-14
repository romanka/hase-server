package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Task implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Long id;
	
	//Stats
	@ManyToOne
    @JoinColumn(name="PRODUCTIVITY_ID")
    private Long productivity_hour;
	
	
	//Content
		@Column(nullable = false) 
	private String taskName;
	
	@Column(nullable = false) 
	private Integer value;
	
	@Column(nullable = false)
	private Boolean productive;
	
	
	/**
	 *  Getter and Setter 
	 **/
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTask() {
		return taskName;
	}

	public void setTaskName(String task) {
		this.taskName = task;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public Boolean getProductive() {
		return productive;
	}

	public void setProductive(Boolean productive) {
		this.productive = productive;
	}

	
	
}
