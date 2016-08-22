package com.catalyst.training.zookeeper.business.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Enclosure Entity
 * 
 * @author treed
 *
 */
@Entity
@Table(name = "enclosure")
public class Enclosure {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "enclosure_id")
	private int enclosureId;

	@Column(name = "name", unique = true)
	private String enclosureName;

	@ManyToOne
	@JoinColumn(name = "animal_id")
	private Animal animal;

	@Column(name = "number_of_animals")
	private int numberOfAnimals;

	// @JsonFormat(pattern = "HH:mm a z")
	@Column(name = "feedingTime")
	private Date feedingTime;

	@Column(name = "enclosureCondition")
	private String enclosureCondition;

	public int getEnclosureId() {
		return enclosureId;
	}

	public void setEnclosureId(int enclosureId) {
		this.enclosureId = enclosureId;
	}

	public String getEnclosureName() {
		return enclosureName;
	}

	public void setEnclosureName(String enclosureName) {
		this.enclosureName = enclosureName;
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	public int getNumberOfAnimals() {
		return numberOfAnimals;
	}

	public void setNumberOfAnimals(int numberOfAnimals) {
		this.numberOfAnimals = numberOfAnimals;
	}

	public Date getFeedingTime() {
		return feedingTime;
	}

	public void setFeedingTime(Date feedingTime) {
		this.feedingTime = feedingTime;
	}

	public String getEnclosureCondition() {
		return enclosureCondition;
	}

	public void setEnclosureCondition(String enclosureCondition) {
		this.enclosureCondition = enclosureCondition;
	}

}
