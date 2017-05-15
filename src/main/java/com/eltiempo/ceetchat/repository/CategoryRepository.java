package com.eltiempo.ceetchat.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.eltiempo.ceetchat.entities.Category;

public interface CategoryRepository  extends MongoRepository<Category, Long>{

}
