package com.catalyst.training.zookeeper.business.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Animal Entity
 * 
 * @author treed
 *
 */
@Entity
@Table(name = "animal")
public class Animal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "animal_id")
	private int animalId;

	@Column(name = "common_name", unique = true)
	private String commonName;

	@Column(name = "scientific_name", unique = true)
	private String scientificName;

	@ManyToOne
	@JoinColumn(name = "favorite_food_id")
	private FavoriteFood favoriteFood;

	@Column(name = "info_link")
	private String infoLink;

	public int getAnimalId() {
		return animalId;
	}

	public void setAnimalId(int animalId) {
		this.animalId = animalId;
	}

	public String getCommonName() {
		return commonName;
	}

	public void setCommonName(String commonName) {
		this.commonName = commonName;
	}

	public String getScientificName() {
		return scientificName;
	}

	public void setScientificName(String scientificName) {
		this.scientificName = scientificName;
	}

	public FavoriteFood getFavoriteFood() {
		return favoriteFood;
	}

	public void setFavoriteFood(FavoriteFood favoriteFood) {
		this.favoriteFood = favoriteFood;
	}

	public String getInfoLink() {
		return infoLink;
	}

	public void setInfoLink(String infoLink) {
		this.infoLink = infoLink;
	}

}
