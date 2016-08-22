package com.catalyst.training.zookeeper.daos;

import java.util.List;

import com.catalyst.training.zookeeper.business.entities.FavoriteFood;

/**
 * Data persistence layer that operates with hibernate For the FavoriteFood
 * entity
 * 
 * @author treed
 *
 */
public interface FavoriteFoodDao {

	/**
	 * Persists an FavoriteFood object to the data base
	 * 
	 * @param favoriteFood
	 */
	void createFavoriteFood(FavoriteFood favoriteFood);

	/**
	 * returns a list of FavoriteFoods
	 * 
	 * @return
	 */

	List<FavoriteFood> getAllFavoriteFoods();

	/**
	 * gets FavoriteFood by the Id
	 * 
	 * @param favoriteFoodId
	 * @return
	 */
	FavoriteFood getFavoriteFoodById(Integer favoriteFoodId);

	/**
	 * updates the current info on an FavoriteFood
	 * 
	 * @param favoriteFood
	 */
	void updateFavoriteFood(FavoriteFood favoriteFood);

}
