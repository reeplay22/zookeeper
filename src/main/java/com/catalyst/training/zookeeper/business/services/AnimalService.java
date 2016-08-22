package com.catalyst.training.zookeeper.business.services;

import java.util.List;

import com.catalyst.training.zookeeper.business.InvalidInputException;
import com.catalyst.training.zookeeper.business.entities.Animal;

/**
 * 
 * Animal entity Service interface
 * 
 * @author treed
 *
 */
public interface AnimalService {

	/**
	 * adds a new animal
	 * 
	 * @param animal
	 * @throws InvalidInputException
	 */
	void createAnimal(Animal animal) throws InvalidInputException;

	/**
	 * Retrieve a list of all animal
	 * 
	 * @return
	 */
	List<Animal> getAllAnimals();

	/**
	 * retrieve single animal By Id
	 * 
	 * @param animalId
	 * @return an instance of animal by is id
	 */
	Animal getAnimalById(Integer animalId);

	/**
	 * update info about the existing animal
	 * 
	 * @param animal
	 */
	void updateAnimal(Animal animal);

}
