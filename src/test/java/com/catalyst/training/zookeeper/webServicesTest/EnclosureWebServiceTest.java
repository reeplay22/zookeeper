package com.catalyst.training.zookeeper.webServicesTest;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;

import com.catalyst.training.zookeeper.business.services.EnclosureService;
import com.catalyst.training.zookeeper.presentation.webservices.EnclosureWebServices;

public class EnclosureWebServiceTest {
	private EnclosureService mockEnclosureService;
	private EnclosureWebServices enclosureWebService;

	@Before
	public void createEnclosureWebService() throws Exception {
		mockEnclosureService = mock(EnclosureService.class);
		enclosureWebService = new EnclosureWebServices();
		enclosureWebService.setEnclosureService(mockEnclosureService);
	}

	@Test
	public void testCreateEnclosure() throws Exception {
		enclosureWebService.createEnclosure(null);
		verify(mockEnclosureService, times(1)).createEnclosure(null);
	}

	@Test
	public void testGetAllenclosures() throws Exception {

		enclosureWebService.getAllEnclosures();
		verify(mockEnclosureService, times(1)).getAllEnclosures();
	}

	@Test
	public void testGetenclosureByID() throws Exception {
		enclosureWebService.getEnclosureById(null);
		verify(mockEnclosureService, times(1)).getEnclosureById(null);
	}

	@Test
	public void testUpdateenclosure() throws Exception {
		enclosureWebService.updateEnclosure(null);
		verify(mockEnclosureService, times(1)).updateEnclosure(null);
	}

	@Test
	public void testDeleteenclosure() throws Exception {
		enclosureWebService.deleteEnclosure(null);
		verify(mockEnclosureService, times(1)).deleteEnclosure(null);
	}

}
