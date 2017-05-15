package com.eltiempo.ceetchat.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.eltiempo.ceetchat.dto.AnswerDTO;
import com.eltiempo.ceetchat.repository.DocumentRepository;
import com.eltiempo.ceetchat.util.UtilWords;

@RestController
public class SearchController {

	@Autowired
	private UtilWords utilWords;

	@Autowired
	DocumentRepository documentRepository;

	@GetMapping("/search/{consulta:.+}")
	public AnswerDTO search(@PathVariable String consulta) {
		String suggestion = utilWords.buildSuggestions(consulta);
		return new AnswerDTO(consulta, suggestion, documentRepository.findAll(), 0);
	}
	
	@GetMapping("/saveWord/{word:.*}")
	public String saveWord(@PathVariable String word){
		utilWords.saveWord(word);
		return word+"-> saved";
	}

}
