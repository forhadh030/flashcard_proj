package com.project.model;

import org.springframework.stereotype.Service;

@Service
public class Flashcard {
	
	Long id;
	String title;
	String description;
	
	private String getTitle() {
		return title;
	}
	private void setTitle(String title) {
		this.title = title;
	}
	private String getDescription() {
		return description;
	}
	private void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "flashcardService [title=" + title + ", description=" + description + "]";
	}
}
