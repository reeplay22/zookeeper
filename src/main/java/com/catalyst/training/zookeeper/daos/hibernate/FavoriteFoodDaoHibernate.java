package com.catalyst.training.zookeeper.daos.hibernate;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.catalyst.training.zookeeper.business.entities.FavoriteFood;
import com.catalyst.training.zookeeper.daos.FavoriteFoodDao;

/**
 * 
 * Implementation class of the Data Access Object layer for the FavoriteFood
 * object
 * 
 * @author treed
 *
 */
@Component
@Transactional
public class FavoriteFoodDaoHibernate implements FavoriteFoodDao {

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
	public void createFavoriteFood(FavoriteFood favoriteFood) {
		em.persist(favoriteFood);
	}

	@Override
	public List<FavoriteFood> getAllFavoriteFoods() {
		return em.createQuery("SELECT a FROM FavoriteFood a ", FavoriteFood.class).getResultList();
	}

	@Override
	public FavoriteFood getFavoriteFoodById(Integer favoriteFoodId) {
		return em.createQuery("SELECT a FROM FavoriteFood a WHERE a.FavoriteFoodId = :FavoriteFood_id",
				FavoriteFood.class).setParameter("FavoriteFood_id", favoriteFoodId).getSingleResult();
	}

	@Override
	public void updateFavoriteFood(FavoriteFood favoriteFood) {
		em.merge(favoriteFood);
	}

}
