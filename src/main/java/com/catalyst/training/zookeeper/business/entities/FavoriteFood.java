package com.catalyst.training.zookeeper.business.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * FavoriteFood Entity
 * 
 * @author treed
 *
 */
@Entity
@Table(name = "favorite_food")
public class FavoriteFood {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "favorite_food_id")
	private int favoriteFoodId;

	@Column(name = "vendor_name")
	private String vendorName;

	@Column(name = "name")
	private String name;

	@Column(name = "category")
	private String category;

	public int getFavoriteFoodId() {
		return favoriteFoodId;
	}

	public void setFavoriteFoodId(int favoriteFoodId) {
		this.favoriteFoodId = favoriteFoodId;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

}
