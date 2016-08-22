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
import com.catalyst.training.zookeeper.business.entities.Enclosure;
import com.catalyst.training.zookeeper.business.services.impl.EnclosureServiceImpl;
import com.catalyst.training.zookeeper.daos.EnclosureDao;

public class EnclosureServiceTest {
	private EnclosureServiceImpl target;
	private EnclosureDao mockEnclosureDao;

	@Before
	public void setup() {
		target = new EnclosureServiceImpl();
		mockEnclosureDao = mock(EnclosureDao.class);
		target.setEnclosureDao(mockEnclosureDao);
	}
 
	@Test(expected=InvalidInputException.class)
	public void testAddenclosureNullName() throws InvalidInputException {
		Enclosure expected = new Enclosure();
		expected.setEnclosureName(null);
		target.createEnclosure(expected);
	}
	
	@Test(expected=InvalidInputException.class)
	public void testAddenclosureEmptyName() throws InvalidInputException {
		Enclosure expected = new Enclosure();
		expected.setEnclosureName("");
		target.createEnclosure(expected);
	}
	
	@Test
	public void testAddenclosureSuccess() throws InvalidInputException {
		Enclosure expected = new Enclosure();
		expected.setEnclosureName("good Stuff");
		target.createEnclosure(expected);
		verify(mockEnclosureDao, times(1)).createEnclosure(expected);
	}

	@Test
	public void testUpdateenclosure() {
		target.updateEnclosure(null);
		verify(mockEnclosureDao, times(1)).updateEnclosure(null);
	}

	@Test
	public void testDeleteenclosure() {

		target.deleteEnclosure(null);
		verify(mockEnclosureDao, times(1)).deleteEnclosure(null);
	}

	@Test(expected=InvalidInputException.class)
	public void testGetByenclosureIdNull() throws InvalidInputException
	{
		target.getEnclosureById(null);
	}

	@Test(expected=InvalidInputException.class)
	public void testGetByenclosureIdZero()throws InvalidInputException
	{
		target.getEnclosureById(-1);
	}

	@Test
	public void testGetByenclosureIdSuccess()throws InvalidInputException
	{
		target.getEnclosureById(1);

		verify(mockEnclosureDao, times(1)).getEnclosureById(any());
	}

	@Test
	public void testGetAllEnclosures() {
		int expected = 2;
		List<Enclosure> enclosures = enclosureList();
		when(mockEnclosureDao.getAllEnclosures()).thenReturn(enclosures);
		List<Enclosure> actual = target.getAllEnclosures();
		assertEquals(expected, actual.size());

	}

	private List<Enclosure> enclosureList() {
		List<Enclosure> enclosures = new ArrayList<>();
		Enclosure e = new Enclosure();
		enclosures.add(e);
		e = new Enclosure();
		enclosures.add(e);
		return enclosures;
	}

}
