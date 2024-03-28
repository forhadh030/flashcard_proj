package com.project.service;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.project.entity.Flashcard;

@Service
public class FlashcardServiceImpl implements FlashcardService {
	
private final String BASE_URI = "http://localhost:8080/api/flashcard/";
	
	@Autowired
	RestTemplate restTemplate;
	private final String baseUrl;
	
	public FlashcardServiceImpl(RestTemplate restTemplate, @Value("${backend.baseUrl}") String baseUrl) {
		this.restTemplate = restTemplate;
		this.baseUrl = baseUrl;
	}
	
	public Flashcard getFlashcard(Long id) {
		System.out.println("Testing getFlashcard API -----------");
		return restTemplate.getForObject(BASE_URI + id, Flashcard.class);
	}

	@Override
	public List<Flashcard> getAllFlashcards() {
		Flashcard[] flashcardsArray = restTemplate.getForObject(BASE_URI, Flashcard[].class);
		List<Flashcard> flashcards = Arrays.asList(flashcardsArray);
		return flashcards;
	}

	@Override
	public void saveFlashcard(Flashcard flashcard) {
		System.out.println("Testing create User API ------------");
		URI uri = restTemplate.postForLocation(BASE_URI + "/create", flashcard, Flashcard.class);
		System.out.println("Location : " + uri.toASCIIString());
		
	}

	@Override
	public Flashcard deleteFlashcard(Long id) {
		String url = BASE_URI + "delete/" + id;
		restTemplate.exchange(url, HttpMethod.DELETE, null, Flashcard.class);
		return this.getFlashcard(id);
	}

	@Override
	public boolean updateFlashcard(Long id, String question, String answer) {
		String url = baseUrl + "/api/flashcard/update" + id + "?question=" + question + "&answer=" + answer;
		try {
			restTemplate.put(url, null);
			return true;
		} catch(RestClientException e) {
			return false;
		}
	}

}
