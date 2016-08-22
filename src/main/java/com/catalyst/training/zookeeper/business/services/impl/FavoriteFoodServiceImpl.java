package com.catalyst.training.zookeeper.business.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catalyst.training.zookeeper.business.entities.FavoriteFood;
import com.catalyst.training.zookeeper.business.services.FavoriteFoodService;
import com.catalyst.training.zookeeper.daos.FavoriteFoodDao;

/**
 * Service Layer for FavoriteFood Object
 * 
 * @author treed
 */

@Service
public class FavoriteFoodServiceImpl implements FavoriteFoodService {

	@Autowired
	private FavoriteFoodDao favoriteFoodDao;

	/**
	 * Sets the Data access layer to be access here in the Service layer
	 * 
	 * @param FavoriteFoodDao
	 */
	public void setFavoriteFoodDao(FavoriteFoodDao favoriteFoodDao) {
		this.favoriteFoodDao = favoriteFoodDao;
	}

	@Override
	public void createFavoriteFood(FavoriteFood favoriteFood) {
		favoriteFoodDao.createFavoriteFood(favoriteFood);
	}

	@Override
	public List<FavoriteFood> getAllFavoriteFoods() {
		return favoriteFoodDao.getAllFavoriteFoods();
	}

	@Override
	public FavoriteFood getFavoriteFoodById(Integer favoriteFoodId) {
		return favoriteFoodDao.getFavoriteFoodById(favoriteFoodId);
	}

	@Override
	public void updateFavoriteFood(FavoriteFood favoriteFood) {
		favoriteFoodDao.updateFavoriteFood(favoriteFood);
	}

}
