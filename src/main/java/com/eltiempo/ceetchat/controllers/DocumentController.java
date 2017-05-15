package com.eltiempo.ceetchat.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eltiempo.ceetchat.entities.Document;
import com.eltiempo.ceetchat.repository.DocumentRepository;

@RestController
public class DocumentController {

	@Autowired
	private DocumentRepository documentRepository;
	
	@GetMapping("/documents/list")
	public List<Document> getDocuments(){
		
		return documentRepository.findAll();
	}
	
	@GetMapping("/documents/{documentName:.*}")
	public List<Document> getDocuments(@PathVariable String documentName){
		return documentRepository.findByDocumentName(documentName);
	}
	
	@PostMapping("/documents/save")
	public String saveDocument(Long id, String documentName, String content){
		documentRepository.save(new Document(id, content, documentName));
		return "saved";
	}
}
