package com.project.dao;

import java.util.List;

import com.project.entity.Flashcard;

public interface FlashcardDAO {
	public List < Flashcard > getFlashcards();
	public void saveFlashcard(Flashcard flashcard);
	public Flashcard getFlashcard(Long id);
	public void deleteFlashcard(Long id);
}
