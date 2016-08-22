package com.catalyst.training.zookeeper.hibernateTest;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.junit.Before;
import org.junit.Test;

import com.catalyst.training.zookeeper.business.entities.FavoriteFood;
import com.catalyst.training.zookeeper.daos.hibernate.FavoriteFoodDaoHibernate;

public class FavoriteFoodHibernateTest {
	private FavoriteFoodDaoHibernate target;

	private EntityManager mockEm;

	@Before
	public void setup() {
		target = new FavoriteFoodDaoHibernate();
		mockEm = mock(EntityManager.class);
		target.setEm(mockEm);
	}

	@Test
	public void testAdd() {

		target.createFavoriteFood(null);
		verify(mockEm, times(1)).persist(null);
	}

	@Test
	public void testGetAllFavoriteFoods() {

		List<FavoriteFood> expected = new ArrayList<>();

		TypedQuery<FavoriteFood> mockTypedQuery = mock(TypedQuery.class);

		when(mockEm.createQuery(anyString(), eq(FavoriteFood.class))).thenReturn(mockTypedQuery);
		when(mockTypedQuery.getResultList()).thenReturn(expected);

		target.getAllFavoriteFoods();

		verify(mockTypedQuery, times(1)).getResultList();

	}

	@Test
	public void testGetByFavoriteFoodId() {
		TypedQuery<FavoriteFood> mockTypedQuery = mock(TypedQuery.class);

		when(mockEm.createQuery(anyString(), eq(FavoriteFood.class))).thenReturn(mockTypedQuery);
		when(mockTypedQuery.setParameter(anyString(), anyInt())).thenReturn(mockTypedQuery);

		target.getFavoriteFoodById(0);
		verify(mockTypedQuery, times(1)).setParameter(eq("FavoriteFood_id"), eq(0));

	}

	@Test
	public void testUpdateFavoriteFood() {
		FavoriteFood expected = new FavoriteFood();
		expected.setFavoriteFoodId(1);

		target.updateFavoriteFood(expected);

		verify(mockEm, times(1)).merge(expected);
	}

}
