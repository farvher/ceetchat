package com.eltiempo.ceetchat.entities;

import java.util.List;

import org.springframework.data.annotation.Id;

public class CommonsWords {

	@Id
	private Long id;

	String word;
	


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}


}
