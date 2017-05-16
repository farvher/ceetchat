package com.eltiempo.ceetchat.entities;

import java.util.List;

import org.springframework.data.annotation.Id;

public class Filters {

	@Id
	private Long id;


	private Boolean active;

	private Category category;

	private Business business;
	
	List<Document> documents;
	
	List<CommonsWords> commonsWords;

	public List<CommonsWords> getCommonsWords() {
		return commonsWords;
	}

	public void setCommonsWords(List<CommonsWords> commonsWords) {
		this.commonsWords = commonsWords;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Business getBusiness() {
		return business;
	}

	public void setBusiness(Business business) {
		this.business = business;
	}

	public List<Document> getDocuments() {
		return documents;
	}

	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

}
