package com.catalyst.training.zookeeper.servicesTest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.catalyst.training.zookeeper.business.entities.FavoriteFood;
import com.catalyst.training.zookeeper.business.services.impl.FavoriteFoodServiceImpl;
import com.catalyst.training.zookeeper.daos.FavoriteFoodDao;

public class FavoriteFoodServiceTest {

	private FavoriteFoodServiceImpl target;
	private FavoriteFoodDao mockFavoriteFoodDao;

	@Before
	public void setup() {
		target = new FavoriteFoodServiceImpl();
		mockFavoriteFoodDao = mock(FavoriteFoodDao.class);
		target.setFavoriteFoodDao(mockFavoriteFoodDao);
	}

	@Test
	public void testCreateFavoriteFood() {
		target.createFavoriteFood(null);
		verify(mockFavoriteFoodDao, times(1)).createFavoriteFood(null);
	}

	@Test
	public void testUpdateFavoriteFood() {
		target.updateFavoriteFood(null);
		verify(mockFavoriteFoodDao, times(1)).updateFavoriteFood(null);
	}


	@Test
	public void testGetByFavoriteFoodIdSuccess(){
		target.getFavoriteFoodById(1);

		verify(mockFavoriteFoodDao, times(1)).getFavoriteFoodById(any());
	}

	@Test
	public void testGetAllFavoriteFoods() {
		int expected = 2;
		List<FavoriteFood> FavoriteFoods = FavoriteFoodList();
		when(mockFavoriteFoodDao.getAllFavoriteFoods()).thenReturn(FavoriteFoods);
		List<FavoriteFood> actual = target.getAllFavoriteFoods();
		assertEquals(expected, actual.size());

	}

	private List<FavoriteFood> FavoriteFoodList() {
		List<FavoriteFood> FavoriteFoods = new ArrayList<>();
		FavoriteFood e = new FavoriteFood();
		FavoriteFoods.add(e);
		e = new FavoriteFood();
		FavoriteFoods.add(e);
		return FavoriteFoods;
	}

}
