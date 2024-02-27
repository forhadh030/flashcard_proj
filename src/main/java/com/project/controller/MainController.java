package com.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.model.Flashcard;

@Controller
public class MainController {
	
	// Synchronous Call (MVC)
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "home_site";
	}
	
	@GetMapping("/createFlashcardForm")
	public String showCreateFlashcardForm(Model model) {
		return "createFlashcard";
	}
	
	@PostMapping(value = "/saveFlashcard")
	public String saveFlashcard(@RequestBody Flashcard flashcard, Model model) {
		String question = flashcard.getQuestion();
		String answer = flashcard.getAnswer();
		
		model.addAttribute("question", question);
		model.addAttribute("answer", answer);
		
		return "flashcardDisplay";
	}
	
	@GetMapping(value = "/flashcardDisplay")
	public String result(@RequestParam("question") String question, @RequestParam("answer") String answer, Model model) {
		model.addAttribute("question", question);
		model.addAttribute("answer", answer);
		return "flashcardDisplay";
	}

}
