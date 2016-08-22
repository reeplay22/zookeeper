package com.catalyst.training.zookeeper.daos.hibernate;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.catalyst.training.zookeeper.business.entities.Enclosure;
import com.catalyst.training.zookeeper.daos.EnclosureDao;

/**
 * 
 * Implementation class of the Data Access Object layer for the Enclosure object
 * 
 * @author treed
 *
 */
@Component
@Transactional
public class EnclosureDaoHibernate implements EnclosureDao {

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
	public void createEnclosure(Enclosure enclosure) {
		em.persist(enclosure);
	}

	@Override
	public List<Enclosure> getAllEnclosures() {
		return em.createQuery("SELECT e FROM Enclosure e ", Enclosure.class).getResultList();
	}

	@Override
	public Enclosure getEnclosureById(Integer enclosureId) {
		return em.find(Enclosure.class, enclosureId);
	}

	@Override
	public void updateEnclosure(Enclosure enclosure) {
		em.merge(enclosure);
	}

	@Override
	public void deleteEnclosure(Integer enclosureId) {
		System.out.println("Hibernate" + enclosureId);
		Enclosure enclosureToDelete = getEnclosureById(enclosureId);
		em.remove(enclosureToDelete);

	}

}
