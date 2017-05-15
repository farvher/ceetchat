package com.eltiempo.ceetchat.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.eltiempo.ceetchat.entities.Business;

public interface BusinessRepository extends MongoRepository<Business, Long> {

}
