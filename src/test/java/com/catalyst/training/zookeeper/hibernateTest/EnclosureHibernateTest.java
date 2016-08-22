package com.catalyst.training.zookeeper.hibernateTest;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.junit.Before;
import org.junit.Test;

import com.catalyst.training.zookeeper.business.entities.Enclosure;
import com.catalyst.training.zookeeper.daos.hibernate.EnclosureDaoHibernate;

public class EnclosureHibernateTest {
	private EnclosureDaoHibernate target;

	private EntityManager mockEm;

	@Before
	public void setup() {
		target = new EnclosureDaoHibernate();
		mockEm = mock(EntityManager.class);
		target.setEm(mockEm);
	}

	@Test
	public void testCreateEnclosure() {
		target.createEnclosure(null);

		verify(mockEm, times(1)).persist(null);
	}

	@Test
	public void testGetAllenclosures() {

		List<Enclosure> expected = new ArrayList<>();

		TypedQuery<Enclosure> mockTypedQuery = mock(TypedQuery.class);

		when(mockEm.createQuery(anyString(), eq(Enclosure.class))).thenReturn(mockTypedQuery);
		when(mockTypedQuery.getResultList()).thenReturn(expected);

		target.getAllEnclosures();

		verify(mockTypedQuery, times(1)).getResultList();

	}

	@Test
	public void testGetByenclosureId() {

		target.getEnclosureById(1);
		verify(mockEm, times(1)).find(Enclosure.class, 1 );

	}
 
	@Test
	public void testUpdate() {
		Enclosure expected = new Enclosure();
		expected.setEnclosureId(1);

		target.updateEnclosure(expected);

		verify(mockEm, times(1)).merge(expected);
	}

	@Test
	public void testDelete() {
		
		//target.createEnclosure(enclosureToDelete);
		target.deleteEnclosure(5);
		Enclosure enclosureToDelete = new Enclosure();
		enclosureToDelete.setEnclosureId(5);
		verify(mockEm, times(1)).remove(5);

	}

}
