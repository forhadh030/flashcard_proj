package com.project.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.project.entity.Flashcard;

@Repository
public class FlashcardDAOImpl implements FlashcardDAO {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public void saveFlashcard(Flashcard flashcard) {
		Session currentSession = em.unwrap(Session.class);
		currentSession.saveOrUpdate(flashcard);
	}

	@Override
	public List<Flashcard> findAll() {
		TypedQuery<Flashcard> query = em.createQuery("Select f FROM Flashcard f", Flashcard.class);
		return query.getResultList();
	}

}
