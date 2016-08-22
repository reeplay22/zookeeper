package com.catalyst.training.zookeeper.presentation.webservices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.catalyst.training.zookeeper.business.entities.FavoriteFood;
import com.catalyst.training.zookeeper.business.services.FavoriteFoodService;

/**
 * Maps the FavoriteFood object CRUD requests
 * 
 * @author treed
 */
@RestController
@RequestMapping(value = "/favoriteFoods")
public class FavoriteFoodWebServices {

	@Autowired
	private FavoriteFoodService favoriteFoodService;

	/**
	 * FavoriteFood service setter for
	 * 
	 * @param FavoriteFoodService
	 */
	public void setFavoriteFoodService(FavoriteFoodService favoriteFoodService) {
		this.favoriteFoodService = favoriteFoodService;
	}

	/**
	 * maps post request to create an FavoriteFood
	 * 
	 * @param favoriteFood
	 * 
	 * 
	 */
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public void createFavoriteFood(@RequestBody FavoriteFood favoriteFood) {
		favoriteFoodService.createFavoriteFood(favoriteFood);

	}

	/**
	 * maps the request to GET FavoriteFood by id
	 * 
	 * @param id
	 * @return favoriteFood object
	 * 
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public FavoriteFood getFavoriteFoodById(@PathVariable Integer id) {
		return favoriteFoodService.getFavoriteFoodById(id);
	}

	/**
	 * maps the request to GET FavoriteFood by id
	 * 
	 * @param id
	 * @return FavoriteFood object
	 * 
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<FavoriteFood> getAllFavoriteFoods() {
		return favoriteFoodService.getAllFavoriteFoods();
	}

	/**
	 * maps the PUT request to update an FavoriteFood
	 * 
	 * @param favoriteFood
	 * 
	 */
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public void updateFavoriteFood(@RequestBody FavoriteFood favoriteFood) {
		favoriteFoodService.updateFavoriteFood(favoriteFood);

	}

}
