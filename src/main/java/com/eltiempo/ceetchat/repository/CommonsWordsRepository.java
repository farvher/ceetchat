package com.eltiempo.ceetchat.repository;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.eltiempo.ceetchat.entities.CommonsWords;

public interface CommonsWordsRepository extends MongoRepository<CommonsWords, Long> {

	CommonsWords findFirstByWordLike(String word);
	
}
