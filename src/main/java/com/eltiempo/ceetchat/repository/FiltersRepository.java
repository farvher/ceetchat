package com.eltiempo.ceetchat.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.eltiempo.ceetchat.entities.Filters;

public interface FiltersRepository extends MongoRepository<Filters, Long>{

}
