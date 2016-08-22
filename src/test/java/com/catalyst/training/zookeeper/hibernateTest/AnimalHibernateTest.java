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

import com.catalyst.training.zookeeper.business.entities.Animal;
import com.catalyst.training.zookeeper.daos.hibernate.AnimalDaoHibernate;

public class AnimalHibernateTest {

	private AnimalDaoHibernate target;

	private EntityManager mockEm;

	@Before
	public void setup() {
		target = new AnimalDaoHibernate();
		mockEm = mock(EntityManager.class);
		target.setEm(mockEm);
	}

	@Test
	public void testAdd() {

		target.createAnimal(null);
		verify(mockEm, times(1)).persist(null);
	}

	@Test
	public void testGetAllAnimals() {

		List<Animal> expected = new ArrayList<>();

		TypedQuery<Animal> mockTypedQuery = mock(TypedQuery.class);

		when(mockEm.createQuery(anyString(), eq(Animal.class))).thenReturn(mockTypedQuery);
		when(mockTypedQuery.getResultList()).thenReturn(expected);

		target.getAllAnimals();

		verify(mockTypedQuery, times(1)).getResultList();

	}

	@Test
	public void testGetByanimalId() {
		TypedQuery<Animal> mockTypedQuery = mock(TypedQuery.class);

		when(mockEm.createQuery(anyString(), eq(Animal.class))).thenReturn(mockTypedQuery);
		when(mockTypedQuery.setParameter(anyString(), anyInt())).thenReturn(mockTypedQuery);

		target.getAnimalById(0);
		verify(mockTypedQuery, times(1)).setParameter(eq("animal_id"), eq(0));

	}

	@Test
	public void testUpdateAnimal() {
		Animal expected = new Animal();
		expected.setAnimalId(1);

		target.updateAnimal(expected);

		verify(mockEm, times(1)).merge(expected);
	}

}
