package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.entity.Flashcard;
import com.project.service.FlashcardService;

@Controller
public class MainController {
	
	@Autowired
	FlashcardService flashcardService;
	
	@RequestMapping(value = "/")
	public ModelAndView home(Model model) {
		ModelAndView mv = new ModelAndView("home_site");
		
		try {
			List<Flashcard> flashcards = flashcardService.getAllFlashcards();
			
			if(flashcards.isEmpty()) {
				mv.addObject("message", "THere are no flashcards available.");
			} else {
				mv.addObject("flashcards", flashcards);
			}
		} catch(Exception e) {
			mv.addObject("message", "Error fetching flashcards: " + e.getMessage());
		}
		
		return mv;
	}
	
	@GetMapping("/createFlashcardForm")
	public String showCreateFlashcardForm(Model model) {
		return "createFlashcard";
	}
	
	@PostMapping(value = "/saveFlashcard")
	public String saveFlashcard(@RequestParam("question") String question, @RequestParam("answer") String answer, Model model) {
		Flashcard flashcard = new Flashcard();
		flashcard.setQuestion(question);
		flashcard.setAnswer(answer);
		flashcardService.saveFlashcard(flashcard);
		
		return "redirect:/";
	}
	
	@GetMapping(value = "/flashcardDisplay")
	public String result(@RequestParam("question") String question, @RequestParam("answer") String answer, Model model) {
		model.addAttribute("question", question);
		model.addAttribute("answer", answer);
		return "flashcardDisplay";
	}

}
