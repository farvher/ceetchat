package com.eltiempo.ceetchat.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eltiempo.ceetchat.entities.CommonsWords;
import com.eltiempo.ceetchat.entities.Document;
import com.eltiempo.ceetchat.entities.Filters;
import com.eltiempo.ceetchat.repository.CommonsWordsRepository;
import com.eltiempo.ceetchat.repository.DocumentRepository;
import com.eltiempo.ceetchat.repository.FiltersRepository;

import ch.qos.logback.core.filter.Filter;

@Service
public class FilterServicesImpl implements FilterServices {

	@Autowired
	CommonsWordsRepository commonsWordsRepository;

	
	@Autowired
	FiltersRepository filtersRepository;
	

	/**
	 * Busca en mongo los documentos que pertenenzcan a los filtros relacionados
	 * de la pregunta TODO debe retornar un dto de filtros y documentos
	 */
	@Override
	public List<Document> findDocumentsByQuestion(String question) {
		
		String [] keyWords = question.split(" ");
		List<Document> documents = new ArrayList<>();
		
		List<Filters> filters  = filtersRepository.findAll();
		for(Filters f : filters){
			documents.addAll(f.getDocuments());
		}
		
		return documents;
	}

}
