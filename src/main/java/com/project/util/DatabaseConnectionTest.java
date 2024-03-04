package com.project.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.FlashcardDAO;
import com.project.entity.Flashcard;

@Service
public class DatabaseConnectionTest {
	
	@Autowired
	private FlashcardDAO flashcardDAO;
	
	public void testConnection() {
		try {
			List<Flashcard> flashcards = flashcardDAO.findAll();
			System.out.println("Number of flashcards retrieved: " + flashcards.size());
		} catch(Exception e) {
			System.err.println("Error testing database connection: " + e.getMessage());
		}
	}
}
