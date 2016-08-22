package com.catalyst.training.zookeeper.presentation.webservices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.catalyst.training.zookeeper.business.InvalidInputException;
import com.catalyst.training.zookeeper.business.entities.Animal;
import com.catalyst.training.zookeeper.business.services.AnimalService;

/**
 * Maps the Animal object CRUD requests
 * 
 * @author treed
 */
@RestController
@RequestMapping(value = "/animals")
public class AnimalWebServices {

	@Autowired
	private AnimalService animalService;

	/**
	 * animal service setter for
	 * 
	 * @param animalService
	 */
	public void setAnimalService(AnimalService animalService) {
		this.animalService = animalService;
	}

	/**
	 * maps post request to create an animal
	 * 
	 * @param animal
	 * 
	 * @throws InvalidInputException
	 */
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public void createAnimal(@RequestBody Animal animal) throws InvalidInputException {
		animalService.createAnimal(animal);

	}

	/**
	 * maps the request to GET animal by id
	 * 
	 * @param id
	 * @return animal object
	 * @throws InvalidInputException
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Animal getAnimalById(@PathVariable Integer id) {
		return animalService.getAnimalById(id);
	}

	/**
	 * maps the request to GET animal by id
	 * 
	 * @param id
	 * @return animal object
	 * @throws InvalidInputException
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Animal> getAllAnimals() {
		return animalService.getAllAnimals();
	}

	/**
	 * maps the PUT request to update an animal
	 * 
	 * @param animal
	 * @throws InvalidInputException
	 */
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public void updateAnimal(@RequestBody Animal animal) {
		animalService.updateAnimal(animal);

	}

}
