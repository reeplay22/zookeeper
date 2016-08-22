package com.catalyst.training.zookeeper.business.services;

import java.util.List;

import com.catalyst.training.zookeeper.business.entities.FavoriteFood;

/**
 * 
 * FavoriteFood entity Service interface
 * 
 * @author treed
 *
 */
public interface FavoriteFoodService {

	/**
	 * adds a new FavoriteFood
	 * 
	 * @param favoriteFood
	 */
	void createFavoriteFood(FavoriteFood favoriteFood);

	/**
	 * Retrieve a list of all FavoriteFood
	 * 
	 * @return
	 */
	List<FavoriteFood> getAllFavoriteFoods();

	/**
	 * retrieve single FavoriteFood By Id
	 * 
	 * @param favoriteFoodId
	 * @return an instance of FavoriteFood by is id
	 */
	FavoriteFood getFavoriteFoodById(Integer favoriteFoodId);

	/**
	 * update info about the existing FavoriteFood
	 * 
	 * @param favoriteFood
	 */
	void updateFavoriteFood(FavoriteFood favoriteFood);

}
