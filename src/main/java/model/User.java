package model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class User implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable = false) 
	private String name;

	@Column(nullable = false, unique = true) 
	private String token;
	
	@Column(nullable = false, unique = true)
	private String rescueTimeKey;
	
	@Column
	private Integer stepsGoal;
	
	@OneToMany
    private List<MorningSurvey> morningSurveys;
	
	@OneToMany
    private List<HourlySurvey> hourlySurveys;
	
	@OneToMany
    private List<EveningSurvey> morningsurveys;
	
	@OneToMany
	private List<Productivity> productivities;
	
	@OneToMany
	private List<Activity> activities;
	
	/**
	 * GETTER AND SETTER
	 */
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getRescueTimeKey() {
		return rescueTimeKey;
	}

	public void setRescueTimeKey(String rescueTimeKey) {
		this.rescueTimeKey = rescueTimeKey;
	}
	
	public Integer getStepsGoal() {
		return stepsGoal;
	}

	public void setStepsGoal(Integer stepsGoal) {
		this.stepsGoal = stepsGoal;
	}

	public List<MorningSurvey> getMorningSurveys() {
		return morningSurveys;
	}

	public void setMorningSurveys(List<MorningSurvey> morningSurveys) {
		this.morningSurveys = morningSurveys;
	}

	public List<HourlySurvey> getHourlySurveys() {
		return hourlySurveys;
	}

	public void setHourlySurveys(List<HourlySurvey> hourlySurveys) {
		this.hourlySurveys = hourlySurveys;
	}

	public List<EveningSurvey> getMorningsurveys() {
		return morningsurveys;
	}

	public void setMorningsurveys(List<EveningSurvey> morningsurveys) {
		this.morningsurveys = morningsurveys;
	}

	public List<Productivity> getProductivities() {
		return productivities;
	}

	public void setProductivities(List<Productivity> productivities) {
		this.productivities = productivities;
	}

	public List<Activity> getActivities() {
		return activities;
	}

	public void setActivities(List<Activity> activities) {
		this.activities = activities;
	}
}
