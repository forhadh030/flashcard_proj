package com.project.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
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
	
	// Per requirement, Execute at least one (1) HQL Query 
	@Override
	public List<Flashcard> getFlashcards() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("FROM Flashcard", Flashcard.class).getResultList();
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

	// Per requirement, Execute at least one (1) Criteria API Query 
	@Override
	public void deleteFlashcard(Long id) {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaDelete<Flashcard> criteriaDelete = builder.createCriteriaDelete(Flashcard.class);
		criteriaDelete.where(builder.equal(criteriaDelete.from(Flashcard.class).get("id"), id));
		session.createQuery(criteriaDelete).executeUpdate();
	}

	@Override
	public void updateFlashcard(Flashcard flashcard) {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		
		// Create an update query for Flashcard entity
		CriteriaUpdate<Flashcard> criteriaUpdate = builder.createCriteriaUpdate(Flashcard.class);
		
		// Set the root of the update query
		Root<Flashcard> root = criteriaUpdate.from(Flashcard.class);
		criteriaUpdate.set("question", flashcard.getQuestion());
		criteriaUpdate.set("answer", flashcard.getAnswer());
		
		// Specify the condition for the update query
		criteriaUpdate.where(builder.equal(root.get("id"), flashcard.getId()));
		session.createQuery(criteriaUpdate).executeUpdate();
	}

}
