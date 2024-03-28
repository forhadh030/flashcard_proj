package com.project.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.entity.Flashcard;

@Service
public interface FlashcardService {
	
	List < Flashcard > getAllFlashcards();
	void saveFlashcard(Flashcard flashcard);
	Flashcard getFlashcard(Long id);
	Flashcard deleteFlashcard(Long id);
	boolean updateFlashcard(Long id, String question, String answer);
}
