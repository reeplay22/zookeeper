package com.catalyst.training.zookeeper.daos.hibernate;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.catalyst.training.zookeeper.business.entities.Animal;
import com.catalyst.training.zookeeper.daos.AnimalDao;

/**
 * 
 * Implementation class of the Data Access Object layer for the Animal object
 * 
 * @author treed
 *
 */
@Component
@Transactional
public class AnimalDaoHibernate implements AnimalDao {

	@PersistenceContext
	private EntityManager em;

	/**
	 * defines entity manager for expense report
	 * 
	 * @param em
	 */
	public void setEm(EntityManager em) {
		this.em = em;
	}

	@Override
	public void createAnimal(Animal animal) {
		em.persist(animal);
	}

	@Override
	public List<Animal> getAllAnimals() {
		return em.createQuery("SELECT a FROM Animal a ", Animal.class).getResultList();
	}

	@Override
	public Animal getAnimalById(Integer animalId) {
		return em.createQuery("SELECT a FROM Animal a WHERE a.animalId = :animal_id", Animal.class)
				.setParameter("animal_id", animalId).getSingleResult();
	}

	@Override
	public void updateAnimal(Animal animal) {
		em.merge(animal);
	}

}
