package com.catalyst.training.zookeeper.business.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catalyst.training.zookeeper.business.InvalidInputException;
import com.catalyst.training.zookeeper.business.entities.Enclosure;
import com.catalyst.training.zookeeper.business.services.EnclosureService;
import com.catalyst.training.zookeeper.daos.EnclosureDao;

/**
 * Service Layer for Enclosure Object
 * 
 * @author treed
 */

@Service
public class EnclosureServiceImpl implements EnclosureService {

	@Autowired
	private EnclosureDao enclosureDao;

	/**
	 * Sets the Data access layer to be access here in the Service layer
	 * 
	 * @param enclosureDao
	 */
	public void setEnclosureDao(EnclosureDao enclosureDao) {
		this.enclosureDao = enclosureDao;
	}

	@Override
	public void createEnclosure(Enclosure enclosure) throws InvalidInputException {
		if ((enclosure.getEnclosureName() == null) || (enclosure.getEnclosureName() == "")) {
			throw new InvalidInputException("name is Null or Empty");
		}
		enclosureDao.createEnclosure(enclosure);
	}

	@Override
	public List<Enclosure> getAllEnclosures() {
		return enclosureDao.getAllEnclosures();
	}

	@Override
	public Enclosure getEnclosureById(Integer enclosureId) throws InvalidInputException {

		if (enclosureId == null || enclosureId < 0) {
			throw new InvalidInputException("EmployeeId.NullOrNegative");
		}
		return enclosureDao.getEnclosureById(enclosureId);
	}

	@Override
	public void updateEnclosure(Enclosure enclosure) {
		enclosureDao.updateEnclosure(enclosure);
	}

	@Override
	public void deleteEnclosure(Integer enclosureId) {
		System.out.println("Services" + enclosureId);
		enclosureDao.deleteEnclosure(enclosureId);
	}

}
