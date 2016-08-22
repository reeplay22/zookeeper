package com.catalyst.training.zookeeper.daos;

import java.util.List;

import com.catalyst.training.zookeeper.business.entities.Enclosure;

/**
 * Data persistence layer that operates with hibernate For the Enclosure entity
 * 
 * @author treed
 *
 */
public interface EnclosureDao {

	/**
	 * Persists an Enclosure object to the data base
	 * 
	 * @param enclosure
	 */

	void createEnclosure(Enclosure enclosure);

	/**
	 * returns a list of enclosures
	 * 
	 * @return
	 */

	List<Enclosure> getAllEnclosures();

	/**
	 * gets enclosure by the Id
	 * 
	 * @param enclosureId
	 * @return
	 */
	Enclosure getEnclosureById(Integer enclosureId);

	/**
	 * updates the current info on an enclosure
	 * 
	 * @param enclosure
	 */
	void updateEnclosure(Enclosure enclosure);

	/**
	 * 
	 * deletes enclosure from the data base
	 * 
	 * @param enclosureId
	 */
	void deleteEnclosure(Integer enclosureId);

}
