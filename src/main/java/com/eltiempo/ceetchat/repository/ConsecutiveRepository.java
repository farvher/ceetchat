package com.eltiempo.ceetchat.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.eltiempo.ceetchat.entities.Consecutive;
import com.eltiempo.ceetchat.enumeration.ConsecutiveEnum;

public interface ConsecutiveRepository extends MongoRepository<Consecutive, Long>{

	Optional<Consecutive> findFirtsByEntity(ConsecutiveEnum consecutiveEnum);
	
}
