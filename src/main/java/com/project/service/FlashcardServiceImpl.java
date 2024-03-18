package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.dao.FlashcardDAO;
import com.project.entity.Flashcard;

@Service
public class FlashcardServiceImpl implements FlashcardService {
	
	@Autowired
    private FlashcardDAO flashcardDAO;
	
	public FlashcardServiceImpl(FlashcardDAO flashcardDAO) {
		this.flashcardDAO = flashcardDAO;
	}

	@Override
	@Transactional
	public List<Flashcard> getFlashcards() {
		return flashcardDAO.getFlashcards();
	}

	@Override
	@Transactional
	public void saveFlashcard(Flashcard flashcard) {
		flashcardDAO.saveFlashcard(flashcard);
	}

	@Override
	@Transactional
	public Flashcard getFlashcard(Long id) {
		return flashcardDAO.getFlashcard(id);
	}

	@Override
	@Transactional
	public void deleteFlashcard(Long id) {
		flashcardDAO.deleteFlashcard(id);
	}

	@Override
	@Transactional
	public void updateFlashcard(Flashcard flashcard) {
		flashcardDAO.updateFlashcard(flashcard);	
	}

}
