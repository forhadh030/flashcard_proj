package com.project.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.project.entity.Flashcard;

@Repository
public interface FlashcardDAO {
	
	void saveFlashcard(Flashcard flashcard);
	List<Flashcard> findAll();
	
}
