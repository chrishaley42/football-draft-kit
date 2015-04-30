package com.chaley.football.draft.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.chaley.football.draft.model.User;

public class UserDAO {
	
	private EntityManager em;
	
	public UserDAO(EntityManager em) {
	    this.em = em;
	  }
	
	public void persist(User entity) {
		em.persist(entity);
	}
	
	@SuppressWarnings("unchecked")
	public List<User> getUser(String email) {
		Query query = em.createQuery("select user from User user where user.email = :email");
	    query.setParameter("email", email);

	    return query.getResultList();
	}

}
