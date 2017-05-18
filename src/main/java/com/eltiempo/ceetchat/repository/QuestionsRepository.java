package com.eltiempo.ceetchat.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.eltiempo.ceetchat.entities.Questions;

public interface QuestionsRepository extends MongoRepository<Questions, Long>{
	
	Optional<Questions> findFirstByQuestion(String question);

}
