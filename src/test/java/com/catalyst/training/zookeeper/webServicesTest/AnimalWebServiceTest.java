package com.catalyst.training.zookeeper.webServicesTest;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;

import com.catalyst.training.zookeeper.business.services.AnimalService;
import com.catalyst.training.zookeeper.presentation.webservices.AnimalWebServices;

public class AnimalWebServiceTest {

	private AnimalService mockAnimalService;
	private AnimalWebServices animalWebService;

	@Before
	public void createAnimalWebService() throws Exception {
		mockAnimalService = mock(AnimalService.class);
		animalWebService = new AnimalWebServices();
		animalWebService.setAnimalService(mockAnimalService);
	}

	@Test
	public void testCreateAnimal() throws Exception {
		animalWebService.createAnimal(null);
		verify(mockAnimalService, times(1)).createAnimal(null);
	}

	@Test
	public void testGetAllAnimals() throws Exception {

		animalWebService.getAllAnimals();
		verify(mockAnimalService, times(1)).getAllAnimals();
	}

	@Test
	public void testGetAnimalByID() throws Exception {
		animalWebService.getAnimalById(null);
		verify(mockAnimalService, times(1)).getAnimalById(null);
	}

	@Test
	public void testUpdateAnimal() throws Exception {
		animalWebService.updateAnimal(null);
		verify(mockAnimalService, times(1)).updateAnimal(null);
	}

}
