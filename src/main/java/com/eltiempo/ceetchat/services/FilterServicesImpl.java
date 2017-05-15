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

@Service
public class FilterServicesImpl implements FilterServices {

	@Autowired
	CommonsWordsRepository commonsWordsRepository;

	@Autowired
	DocumentRepository DocumentRepository;

	/**
	 * Busca en mongo los documentos que pertenenzcan a los filtros relacionados
	 * de la pregunta TODO debe retornar un dto de filtros y documentos
	 */
	@Override
	public List<Document> findDocumentsByQuestion(String question) {

		List<Document> documents = new ArrayList<>();
		CommonsWords commonsWords = commonsWordsRepository.findFirstByWordLike(question.toLowerCase().trim());
		if (commonsWords != null) {
			Filters f = commonsWords.getFilter();
			if (f != null) {
				documents.addAll(f.getDocuments());
			}
		}
		return documents;
	}

}
