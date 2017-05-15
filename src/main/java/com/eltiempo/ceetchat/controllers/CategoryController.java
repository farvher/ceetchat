package com.eltiempo.ceetchat.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eltiempo.ceetchat.entities.Category;
import com.eltiempo.ceetchat.repository.CategoryRepository;

@RestController
public class CategoryController {

	@Autowired
	CategoryRepository categoryRepository;

	@GetMapping("/categories/list")
	public List<Category> getCategories() {

		return categoryRepository.findAll();
	}

	@PostMapping("/categories/save")
	public String saveCategory(Long id, String categoryName) {
		Category category = new Category(id, categoryName);
		categoryRepository.save(category);
		return "saved";
	}

	@PostMapping("/categories/deleteAll")
	public String deleteAll() {
		categoryRepository.deleteAll();
		return "deleted all";
	}

}
