package com.catalyst.training.zookeeper.entitiesTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import org.junit.Before;
import org.junit.Test;

import com.catalyst.training.zookeeper.business.entities.Animal;
import com.catalyst.training.zookeeper.business.entities.FavoriteFood;

public class AnimalTest {

	private Animal target;

	@Before
	public void setup() {
		target = new Animal();
	}

	@Test
	public void testGettersandSetters() {
		FavoriteFood favoriteFood = new FavoriteFood();
		target.setAnimalId(1);
		target.setCommonName("yogibear");
		target.setScientificName("sum com laddi");
		target.setInfoLink("igotdis.com");
		target.setFavoriteFood(favoriteFood);

		assertEquals(target.getAnimalId(), 1);
		assertSame(target.getCommonName(), "yogibear");
		assertSame(target.getScientificName(), "sum com laddi");
		assertSame(target.getInfoLink(), "igotdis.com");
		assertEquals(target.getFavoriteFood(), favoriteFood);
	}
}
