package com.catalyst.training.zookeeper.business.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catalyst.training.zookeeper.business.InvalidInputException;
import com.catalyst.training.zookeeper.business.entities.Animal;
import com.catalyst.training.zookeeper.business.services.AnimalService;
import com.catalyst.training.zookeeper.daos.AnimalDao;

/**
 * Service Layer for Animal Object
 * 
 * @author treed
 */

@Service
public class AnimalServiceImpl implements AnimalService {

	@Autowired
	private AnimalDao animalDao;

	/**
	 * Sets the Data access layer to be access here in the Service layer
	 * 
	 * @param animalDao
	 */
	public void setAnimalDao(AnimalDao animalDao) {
		this.animalDao = animalDao;
	}

	@Override
	public void createAnimal(Animal animal) throws InvalidInputException {
		if ((animal.getCommonName() == null) || (animal.getCommonName() == "")) {

			throw new InvalidInputException("name null or empty");
		}
		animalDao.createAnimal(animal);
	}

	@Override
	public List<Animal> getAllAnimals() {
		return animalDao.getAllAnimals();
	}

	@Override
	public Animal getAnimalById(Integer animalId) {
		return animalDao.getAnimalById(animalId);
	}

	@Override
	public void updateAnimal(Animal animal) {
		animalDao.updateAnimal(animal);
	}

}
