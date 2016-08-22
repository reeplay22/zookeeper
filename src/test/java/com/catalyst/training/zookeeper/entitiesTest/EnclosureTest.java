package com.catalyst.training.zookeeper.entitiesTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import java.sql.Time;

import org.junit.Before;
import org.junit.Test;

import com.catalyst.training.zookeeper.business.entities.Animal;
import com.catalyst.training.zookeeper.business.entities.Enclosure;

public class EnclosureTest {

	private Enclosure target;

	@Before
	public void setup() {
		target = new Enclosure();
	}

	@Test
	public void testGettersandSetters() {
		Animal animal = new Animal();
		Time time = new Time(0);
		target.setEnclosureId(1);
		target.setEnclosureName("yogibear");
		target.setNumberOfAnimals(2);
		target.setFeedingTime(time);
		target.setAnimal(animal);
		target.setEnclosureCondition("great");

		assertEquals(target.getEnclosureId(), 1);
		assertEquals(target.getEnclosureName(), "yogibear");
		assertEquals(target.getNumberOfAnimals(), 2);
		assertSame(target.getFeedingTime(), time);
		assertSame(target.getAnimal(), animal);
		assertEquals(target.getEnclosureCondition(), "great");
	}
}
