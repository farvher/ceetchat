package com.eltiempo.ceetchat.dto;

import java.io.Serializable;

public class DocumentDTO implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String question;
	
	private Long business;
	
	private Long category;
	
	private String content;

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public Long getBusiness() {
		return business;
	}

	public void setBusiness(Long business) {
		this.business = business;
	}

	public Long getCategory() {
		return category;
	}

	public void setCategory(Long category) {
		this.category = category;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	

}
