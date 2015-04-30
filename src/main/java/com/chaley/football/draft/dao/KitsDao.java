package com.chaley.football.draft.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.chaley.football.draft.model.Kit;

public class KitsDao {
	
	private EntityManager em;
	
	public KitsDao(EntityManager em) {
		this.em = em;
	}
	
	public void persist(Kit entity) {
		em.persist(entity);
	}
	
	@SuppressWarnings("unchecked")
	public List<Kit> getUserKits(Long id) {
		Query query = em.createQuery("select Kit from Kit kit where kit.id = :id");
		query.setParameter("id",id);
		
		return query.getResultList();
	}

}
