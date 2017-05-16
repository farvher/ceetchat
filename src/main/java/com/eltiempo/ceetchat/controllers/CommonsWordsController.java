package com.eltiempo.ceetchat.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.eltiempo.ceetchat.dto.DocumentDTO;
import com.eltiempo.ceetchat.entities.Business;
import com.eltiempo.ceetchat.entities.Category;
import com.eltiempo.ceetchat.entities.CommonsWords;
import com.eltiempo.ceetchat.entities.Document;
import com.eltiempo.ceetchat.entities.Filters;
import com.eltiempo.ceetchat.repository.BusinessRepository;
import com.eltiempo.ceetchat.repository.CategoryRepository;
import com.eltiempo.ceetchat.repository.CommonsWordsRepository;
import com.eltiempo.ceetchat.repository.DocumentRepository;
import com.eltiempo.ceetchat.repository.FiltersRepository;

import scala.annotation.meta.setter;

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
	

	@GetMapping("/question/save")
	public String getForm(Model model, String msg){
		model.addAttribute("document", new DocumentDTO());
		model.addAttribute("business",businessRepository.findAll());
		model.addAttribute("categories", categoryRepository.findAll());
		return INDEX;
	}
	
	@PostMapping("/question/save")
	public String saveForm(Model model,@ModelAttribute DocumentDTO documentDto){
		
		String [] keyWords = documentDto.getQuestion().split(",");
		Optional<Business> business = businessRepository.findById(documentDto.getBusiness());
		Optional <Category> category = categoryRepository.findById(documentDto.getCategory());
		Optional<Filters> filtersOptional =  filtersRepository.findFirstByBusinessAndCategory(business.get(), category.get());
		Long pos = documentRepository.count();
		Document document = new Document(pos, documentDto.getContent(),"");
		
		if(filtersOptional.isPresent()){
			filtersOptional.get().getDocuments().add(document);
			
		}else{
			Filters filters = new Filters();
			filters.setActive(true);
			filters.setBusiness(business.get());
			filters.setCategory(category.get());
			List<Document> listDocument = new ArrayList<>();
			listDocument.add(document);
			saveKeyWords(keyWords, filters);
		}
		
		

		
		return "redirect:/index";
	}
	
	private void saveKeyWords(String [] keyWords , Filters filters){
		for(String k : keyWords){
			CommonsWords commonsWords  = new CommonsWords();
			commonsWords.setFilter(filters);
			commonsWords.setWord(k);
			commonsWords.setId(commonsWordsRepository.count()+1);
			commonsWordsRepository.save(commonsWords);
			
		}
		
		
	}
	

}
