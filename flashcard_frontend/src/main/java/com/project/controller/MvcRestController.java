package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.project.FlashcardProvider.entity.Flashcard;

@RestController
@EnableWebMvc
public class MvcRestController {
	
	private final String BASE_URL = "http://localhost:8080/api/flashcard";
	
	@Autowired
	RestTemplate restTemplate;
	
	@PostMapping
	public Flashcard createFlashcard(Flashcard flashcard) {
		return restTemplate.postForObject(BASE_URL + "/create", flashcard, Flashcard.class);
	}
}
