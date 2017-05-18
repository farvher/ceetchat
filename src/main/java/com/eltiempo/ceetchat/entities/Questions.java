package com.eltiempo.ceetchat.entities;

import org.springframework.data.annotation.Id;

public class Questions {

	
	@Id
	private Long id;
	
	private String question;
	
	private Long count;

	public Questions(Long id, String question, Long count) {
		super();
		this.id = id;
		this.question = question;
		this.count = count;
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

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}
}
