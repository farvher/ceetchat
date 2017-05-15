package com.eltiempo.ceetchat.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.eltiempo.ceetchat.entities.CommonsWords;
import com.eltiempo.ceetchat.repository.BusinessRepository;
import com.eltiempo.ceetchat.repository.CategoryRepository;
import com.eltiempo.ceetchat.repository.CommonsWordsRepository;

@Controller
public class CommonsWordsController {
	
	
	private static final String INDEX = "index";
	
	@Autowired
	private CommonsWordsRepository commonsWordsRepository;
	
	@Autowired
	private BusinessRepository businessRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	

	@GetMapping("/question/save")
	public String getForm(Model model, String msg){
		model.addAttribute("common", new CommonsWords());
		model.addAttribute("business",businessRepository.findAll());
		model.addAttribute("categories", categoryRepository.findAll());
		return INDEX;
	}
	
	@PostMapping("/question/save")
	public String saveForm(Model model,@ModelAttribute CommonsWords common){
		commonsWordsRepository.save(common);
		return "redirect:/index";
	}
	

}
