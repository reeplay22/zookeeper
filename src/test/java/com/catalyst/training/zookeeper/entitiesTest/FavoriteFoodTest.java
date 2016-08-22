package com.catalyst.training.zookeeper.entitiesTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import org.junit.Before;
import org.junit.Test;

import com.catalyst.training.zookeeper.business.entities.FavoriteFood;

public class FavoriteFoodTest {

	private FavoriteFood target;

	@Before
	public void setup() {
		target = new FavoriteFood();
	}

	@Test
	public void testGettersandSetters() {
		target.setFavoriteFoodId(1);
		target.setName("yogibear");
		target.setVendorName("sum com laddi");
		target.setCategory("igotdis.com");

		assertEquals(target.getFavoriteFoodId(), 1);
		assertSame(target.getName(), "yogibear");
		assertSame(target.getVendorName(), "sum com laddi");
		assertSame(target.getCategory(), "igotdis.com");
	}

}
