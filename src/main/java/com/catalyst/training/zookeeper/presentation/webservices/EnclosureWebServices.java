package com.catalyst.training.zookeeper.presentation.webservices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.catalyst.training.zookeeper.business.InvalidInputException;
import com.catalyst.training.zookeeper.business.entities.Enclosure;
import com.catalyst.training.zookeeper.business.services.EnclosureService;

/**
 * Maps the Enclosure object CRUD requests from the front end
 * 
 * @author treed
 */
@RestController
@RequestMapping(value = "/enclosures")
public class EnclosureWebServices {

	@Autowired
	private EnclosureService enclosureService;

	/**
	 * enclosure service setter for
	 * 
	 * @param enclosureService
	 */
	public void setEnclosureService(EnclosureService enclosureService) {
		this.enclosureService = enclosureService;
	}

	/**
	 * maps post request to create an enclosure
	 * 
	 * @param enclosure
	 * 
	 * @throws InvalidInputException
	 */
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public void createEnclosure(@RequestBody Enclosure enclosure) throws InvalidInputException {
		enclosureService.createEnclosure(enclosure);

	}

	/**
	 * maps the request to GET enclosure by id
	 * 
	 * @param id
	 * @return enclosure object
	 * @throws InvalidInputException
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Enclosure getEnclosureById(@PathVariable Integer id) throws InvalidInputException {
		return enclosureService.getEnclosureById(id);
	}

	/**
	 * maps the request to GET all enclosures and puts them in a list
	 * 
	 * @param id
	 * @return enclosure object
	 * @throws InvalidInputException
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Enclosure> getAllEnclosures() {
		return enclosureService.getAllEnclosures();
	}

	/**
	 * maps the PUT request to update an enclosure
	 * 
	 * @param enclosure
	 * @throws InvalidInputException
	 */
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public void updateEnclosure(@RequestBody Enclosure enclosure) {
		enclosureService.updateEnclosure(enclosure);

	}

	/**
	 * maps the DELETE request to delete an enclosure
	 * 
	 * @param enclosure
	 * 
	 */
	@RequestMapping(value = "/delete/{enclosureId}", method = RequestMethod.DELETE)
	public void deleteEnclosure(@PathVariable Integer enclosureId) {
		
		System.out.println("Web Services " + enclosureId);
		enclosureService.deleteEnclosure(enclosureId);

	}

}
