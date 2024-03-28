package com.project.FlashcardProvider.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "flashcard")
public class Flashcard {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique=true)
	private Long id;

	@Column(name = "QUESTION")
	private String question;

	@Column(name = "ANSWER")
	private String answer;

	@Temporal(TemporalType.DATE)
	@Column(name = "DATE")
	private Date date;

	public Flashcard(){}

	public Flashcard(String question, String answer){
		this.question = question;
		this.answer = answer;
	}

	public Flashcard(String question, String answer, Date date){
		this.question = question;
		this.answer = answer;
		this.date = date;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}

	@Override
	public String toString() {
		return "Flashcard [id=" + id + ", question=" + question + ", answer=" + answer + "]";
	}

}
