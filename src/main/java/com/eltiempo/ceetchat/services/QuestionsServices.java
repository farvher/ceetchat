package com.eltiempo.ceetchat.services;

import com.eltiempo.ceetchat.entities.Questions;

public interface QuestionsServices {

	
	void saveQuestion(String question);
	
	Questions getQuestion(String question);
	
}
