package com.catalyst.training.zookeeper.daos;

import java.util.List;

import com.catalyst.training.zookeeper.business.entities.Animal;

/**
 * Data persistence layer that operates with hibernate For the animal entity
 * 
 * @author treed
 *
 */
public interface AnimalDao {

	/**
	 * Persists an animal object to the data base
	 * 
	 * @param animal
	 */
	void createAnimal(Animal animal);

	/**
	 * returns a list of Animals
	 * 
	 * @return
	 */

	List<Animal> getAllAnimals();

	/**
	 * gets Animal by the Id
	 * 
	 * @param animalId
	 * @return
	 */
	Animal getAnimalById(Integer animalId);

	/**
	 * updates the current info on an animal
	 * 
	 * @param animal
	 */
	void updateAnimal(Animal animal);

}
