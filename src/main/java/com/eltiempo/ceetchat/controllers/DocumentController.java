package com.eltiempo.ceetchat.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eltiempo.ceetchat.entities.Document;
import com.eltiempo.ceetchat.entities.Filters;
import com.eltiempo.ceetchat.repository.DocumentRepository;
import com.eltiempo.ceetchat.repository.FiltersRepository;

@RestController
public class DocumentController {

	@Autowired
	private DocumentRepository documentRepository;
	
	@Autowired 
	private FiltersRepository filtersRepository;
	
	@GetMapping("/documents/list")
	public List<Filters> getDocuments(){
		
		return filtersRepository.findAll();
	}
	
	@GetMapping("/documents/delete")
	public String deleteAll(){
		filtersRepository.deleteAll();
		return "deleted";
	}
	
	
}
