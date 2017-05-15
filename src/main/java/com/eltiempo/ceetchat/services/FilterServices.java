package com.eltiempo.ceetchat.services;

import java.util.List;

import com.eltiempo.ceetchat.entities.Document;

public interface FilterServices {

	List<Document> findDocumentsByQuestion(String question);
	
	
}
