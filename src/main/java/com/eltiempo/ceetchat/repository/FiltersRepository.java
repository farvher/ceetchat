package com.eltiempo.ceetchat.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.eltiempo.ceetchat.entities.Business;
import com.eltiempo.ceetchat.entities.Category;
import com.eltiempo.ceetchat.entities.Filters;

public interface FiltersRepository extends MongoRepository<Filters, Long>{

	Optional<Filters> findFirstByBusinessAndCategory(Business business,Category category); 
}
