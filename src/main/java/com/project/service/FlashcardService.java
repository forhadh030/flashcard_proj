package com.project.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.entity.Flashcard;

@Service
public interface FlashcardService {
	
	List < Flashcard > getFlashcards();
	void saveFlashcard(Flashcard flashcard);
	Flashcard getFlashcard(Long id);
	void deleteFlashcard(Long id);
	void updateFlashcard(Flashcard flashcard);
}
