package com.project.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.entity.Flashcard;

@Repository
public class FlashcardDAOImpl implements FlashcardDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Flashcard> getFlashcards() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery <Flashcard> cq = cb.createQuery(Flashcard.class);
		Root < Flashcard > root = cq.from(Flashcard.class);
		cq.select(root);
		Query query = session.createQuery(cq);
		return query.getResultList();
	}

	@Override
	public void saveFlashcard(Flashcard flashcard) {
		Session session = sessionFactory.getCurrentSession();
		session.save(flashcard);
	}
	
	@Override
	public Flashcard getFlashcard(Long id) {
		Session currentSession = sessionFactory.getCurrentSession();
		Flashcard flashcard = currentSession.get(Flashcard.class, id);
		return flashcard;
	}

	@Override
	public void deleteFlashcard(Long id) {
		Session session = sessionFactory.getCurrentSession();
		Flashcard flashcard = session.byId(Flashcard.class).load(id);
		session.delete(flashcard);
	}

}
