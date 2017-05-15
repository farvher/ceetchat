package com.eltiempo.ceetchat.dto;

import java.util.List;

import com.eltiempo.ceetchat.entities.Document;

public class AnswerDTO {
	
	private String question;
	
	private String suggestions;
	
	private List<Document> Documents;
	
	private int count;
	
	

	public AnswerDTO(String question, String suggestions, List<Document> documents, int count) {
		super();
		this.question = question;
		this.suggestions = suggestions;
		Documents = documents;
		this.count = count;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getSuggestions() {
		return suggestions;
	}

	public void setSuggestions(String suggestions) {
		this.suggestions = suggestions;
	}

	public List<Document> getDocuments() {
		return Documents;
	}

	public void setDocuments(List<Document> documents) {
		Documents = documents;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	
	
	
	

}
