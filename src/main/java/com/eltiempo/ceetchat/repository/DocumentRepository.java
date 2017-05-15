package com.eltiempo.ceetchat.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.eltiempo.ceetchat.entities.Document;

public interface DocumentRepository extends MongoRepository<Document, Long>{

	List<Document> findByDocumentName(String documentName);
}
