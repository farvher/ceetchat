package com.eltiempo.ceetchat.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.eltiempo.ceetchat.dto.AnswerDTO;
import com.eltiempo.ceetchat.repository.DocumentRepository;
import com.eltiempo.ceetchat.repository.QuestionsRepository;
import com.eltiempo.ceetchat.services.FilterServices;
import com.eltiempo.ceetchat.services.QuestionsServices;
import com.eltiempo.ceetchat.util.UtilWords;

@RestController
public class SearchController {

	@Autowired
	private UtilWords utilWords;

	@Autowired
	private FilterServices filterService;
	
	@Autowired
	private QuestionsServices questionsService;

	@GetMapping("/search/{consulta:.+}")
	public AnswerDTO search(@PathVariable String consulta, Integer count) {
		String suggestion = utilWords.buildSuggestions(consulta);
		questionsService.saveQuestion(consulta);
		questionsService.saveQuestion(suggestion);
		return new AnswerDTO(consulta, suggestion, filterService.findDocumentsByQuestion(consulta),
				count != null ? count : 0);
	}

	@GetMapping("/saveWord/{word:.*}")
	public String saveWord(@PathVariable String word) {
		utilWords.saveWord(word);
		return word + "-> saved";
	}
	

}
