package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;
import com.project.entity.Flashcard;
import com.project.service.FlashcardService;


@Controller
public class MainController {
	
	@Autowired
	private FlashcardService flashcardService;
	
	@GetMapping(value = "/")
	public String home() {
		return "home";
	}
	
	@GetMapping(value = "/viewFlashcards")
	public String viewAllFlashcards(Model model) {
		List<Flashcard> flashcards = flashcardService.getAllFlashcards();
		model.addAttribute("flashcard", flashcards);
		return "viewFlashcards";
	}
	
	@GetMapping("/editFlashcard")
	public String showEditFlashcardForm(@RequestParam("id") Long id, Model model) {
		Flashcard flashcard = flashcardService.getFlashcard(id);
		model.addAttribute("flashcardJson", new Gson().toJson(flashcard));
		return "editFlashcard";
	}
	
	@PutMapping("/update")
	public String updateFlashcard(@RequestBody Flashcard flashcard) {
		return "redirect:/viewFlashcards";
	}

}
