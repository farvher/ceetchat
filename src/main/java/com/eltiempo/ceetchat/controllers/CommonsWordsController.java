package com.eltiempo.ceetchat.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.eltiempo.ceetchat.dto.DocumentDTO;
import com.eltiempo.ceetchat.entities.Business;
import com.eltiempo.ceetchat.entities.Category;
import com.eltiempo.ceetchat.entities.CommonsWords;
import com.eltiempo.ceetchat.entities.Consecutive;
import com.eltiempo.ceetchat.entities.Document;
import com.eltiempo.ceetchat.entities.Filters;
import com.eltiempo.ceetchat.enumeration.ConsecutiveEnum;
import com.eltiempo.ceetchat.repository.BusinessRepository;
import com.eltiempo.ceetchat.repository.CategoryRepository;
import com.eltiempo.ceetchat.repository.CommonsWordsRepository;
import com.eltiempo.ceetchat.repository.DocumentRepository;
import com.eltiempo.ceetchat.repository.FiltersRepository;
import com.eltiempo.ceetchat.services.ConsecutiveService;

@Controller
public class CommonsWordsController {

	private static final String INDEX = "index";

	@Autowired
	private CommonsWordsRepository commonsWordsRepository;

	@Autowired
	private BusinessRepository businessRepository;

	@Autowired
	private DocumentRepository documentRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private FiltersRepository filtersRepository;

	@Autowired
	private ConsecutiveService consecutiveService;

	@GetMapping("/question/save")
	public String getForm(Model model, String msg) {
		model.addAttribute("document", new DocumentDTO());
		model.addAttribute("business", businessRepository.findAll());
		model.addAttribute("categories", categoryRepository.findAll());
		return INDEX;
	}

	@PostMapping("/question/save")
	public String saveForm(Model model, @ModelAttribute DocumentDTO documentDto) {

		String[] keyWords = documentDto.getQuestion().split(",");
		Optional<Business> business = businessRepository.findById(documentDto.getBusiness());
		Optional<Category> category = categoryRepository.findById(documentDto.getCategory());

		Long documentPos = consecutiveService.getConsecutive(ConsecutiveEnum.DOCUMENT);
		Document document = new Document(documentPos, documentDto.getContent(), "");

		Filters filters = new Filters();
		Long filterPos = consecutiveService.getConsecutive(ConsecutiveEnum.FILTER);
		filters.setId(filterPos);
		List<CommonsWords> commonsList = new ArrayList<>();
		List<Document> listDocument = new ArrayList<>();

		filters.setActive(true);
		filters.setBusiness(business.get());
		filters.setCategory(category.get());
		listDocument.add(document);
		filters.setDocuments(listDocument);
		filters.setCommonsWords(commonsList);
		saveKeyWords(keyWords, filters);

		return "redirect:/question/save";
	}

	private void saveKeyWords(String[] keyWords, Filters filters) {
		for (String k : keyWords) {
			CommonsWords commonsWords = new CommonsWords();
			commonsWords.setWord(k);
			commonsWords.setId(commonsWordsRepository.count() + 1);
			filters.getCommonsWords().add(commonsWords);
		}
		filtersRepository.save(filters);
	}

}
