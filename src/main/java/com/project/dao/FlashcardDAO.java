package com.project.dao;

import java.util.List;

import com.project.entity.Flashcard;

public interface FlashcardDAO {
	List < Flashcard > getFlashcards();
	void saveFlashcard(Flashcard flashcard);
	Flashcard getFlashcard(Long id);
	void deleteFlashcard(Long id);
	void updateFlashcard(Flashcard flashcard);
}
