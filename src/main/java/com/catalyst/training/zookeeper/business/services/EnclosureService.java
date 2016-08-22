package com.catalyst.training.zookeeper.business.services;

import java.util.List;

import com.catalyst.training.zookeeper.business.InvalidInputException;
import com.catalyst.training.zookeeper.business.entities.Enclosure;

/**
 * 
 * Enclosure entity Service Layer interface this is where logic, validation and
 * exceptions are placed to ensure that bad data does not go to the data base
 * 
 * @author treed
 *
 */
public interface EnclosureService {

	/**
	 * add a new enclosure
	 * 
	 * @param enclosure
	 * @throws InvalidInputException
	 */
	void createEnclosure(Enclosure enclosure) throws InvalidInputException;

	/**
	 * Retrieve a list of all enclosure
	 * 
	 * @return a list of all enclosures
	 */
	List<Enclosure> getAllEnclosures();

	/**
	 * retrieve single enclosure By Id
	 * 
	 * @param enclosureId
	 * @return an instance of enclosure by is id
	 * @throws InvalidInputException
	 */
	Enclosure getEnclosureById(Integer enclosureId) throws InvalidInputException;

	/**
	 * update info about the existing enclosure
	 * 
	 * @param enclosure
	 */
	void updateEnclosure(Enclosure enclosure);

	/**
	 * removes an enclosure
	 * 
	 * @param enclosureId
	 */
	void deleteEnclosure(Integer enclosureId);

}
