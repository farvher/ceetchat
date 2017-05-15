package com.eltiempo.ceetchat.entities;

import org.springframework.data.annotation.Id;

public class Category {
	
	
	@Id
	private Long id;
	
	private String categoryName;

	
	
	public Category(Long id, String categoryName) {
		super();
		this.id = id;
		this.categoryName = categoryName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		categoryName = categoryName;
	}
	
	


}
