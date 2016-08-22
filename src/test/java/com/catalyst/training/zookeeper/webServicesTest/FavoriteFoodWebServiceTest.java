package com.catalyst.training.zookeeper.webServicesTest;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;

import com.catalyst.training.zookeeper.business.services.FavoriteFoodService;
import com.catalyst.training.zookeeper.presentation.webservices.FavoriteFoodWebServices;

public class FavoriteFoodWebServiceTest {

	private FavoriteFoodService mockFavoriteFoodService;
	private FavoriteFoodWebServices FavoriteFoodWebService;

	@Before
	public void createFavoriteFoodWebService() throws Exception {
		mockFavoriteFoodService = mock(FavoriteFoodService.class);
		FavoriteFoodWebService = new FavoriteFoodWebServices();
		FavoriteFoodWebService.setFavoriteFoodService(mockFavoriteFoodService);
	}

	@Test
	public void testCreateFavoriteFood() throws Exception {
		FavoriteFoodWebService.createFavoriteFood(null);
		verify(mockFavoriteFoodService, times(1)).createFavoriteFood(null);
	}

	@Test
	public void testGetAllFavoriteFoods() throws Exception {

		FavoriteFoodWebService.getAllFavoriteFoods();
		verify(mockFavoriteFoodService, times(1)).getAllFavoriteFoods();
	}

	@Test
	public void testGetFavoriteFoodByID() throws Exception {
		FavoriteFoodWebService.getFavoriteFoodById(null);
		verify(mockFavoriteFoodService, times(1)).getFavoriteFoodById(null);
	}

	@Test
	public void testUpdateFavoriteFood() throws Exception {
		FavoriteFoodWebService.updateFavoriteFood(null);
		verify(mockFavoriteFoodService, times(1)).updateFavoriteFood(null);
	}

}
