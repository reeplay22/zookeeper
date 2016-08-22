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

import com.catalyst.training.zookeeper.business.InvalidInputException;
import com.catalyst.training.zookeeper.business.entities.Animal;
import com.catalyst.training.zookeeper.business.services.impl.AnimalServiceImpl;
import com.catalyst.training.zookeeper.daos.AnimalDao;

public class AnimalServiceTest {

	private AnimalServiceImpl target;
	private AnimalDao mockanimalDao;

	@Before
	public void setup() {
		target = new AnimalServiceImpl();
		mockanimalDao = mock(AnimalDao.class);
		target.setAnimalDao(mockanimalDao);
	}
	
	@Test(expected=InvalidInputException.class)
	public void testCreateAnimalNull() throws InvalidInputException {
		Animal expected = new Animal();
		expected.setCommonName(null);
		target.createAnimal(expected);
	}
	
	@Test(expected=InvalidInputException.class)
	public void testCreateAnimalEmpty() throws InvalidInputException {
		Animal expected = new Animal();
		expected.setCommonName("");
		target.createAnimal(expected);
	
	}

	@Test
	public void testCreateAnimalSuccess() throws InvalidInputException {
		Animal expected = new Animal();
		expected.setCommonName("nice stuff");
		target.createAnimal(expected);
		verify(mockanimalDao, times(1)).createAnimal(expected);
	}

	@Test
	public void testUpdateAnimal() {
		target.updateAnimal(null);
		verify(mockanimalDao, times(1)).updateAnimal(null);
	}


	@Test
	public void testGetByanimalIdNull() {
		target.getAnimalById(null);
	}

	@Test
	public void testGetByanimalIdZero() {
		target.getAnimalById(-1);
	}

	@Test
	public void testGetByanimalIdSuccess(){
		target.getAnimalById(1);
		verify(mockanimalDao, times(1)).getAnimalById(any());
	}

	@Test
	public void testGetAllAnimals() {
		int expected = 2;
		List<Animal> animals = AnimalList();
		when(mockanimalDao.getAllAnimals()).thenReturn(animals);
		List<Animal> actual = target.getAllAnimals();
		assertEquals(expected, actual.size());

	}

	private List<Animal> AnimalList() {
		List<Animal> animals = new ArrayList<>();
		Animal e = new Animal();
		animals.add(e);
		e = new Animal();
		animals.add(e);
		return animals;
	}

}
