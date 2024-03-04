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

	@Override
	@Transactional
	public void saveFlashcard(Flashcard flashcard) {
		flashcardDAO.saveFlashcard(flashcard);
	}

	@Override
	public List<Flashcard> getAllFlashcards() {
		return flashcardDAO.findAll();
	}

}
