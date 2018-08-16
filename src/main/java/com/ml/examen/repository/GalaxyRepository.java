package com.ml.examen.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ml.examen.model.Galaxy;

public interface GalaxyRepository extends MongoRepository<Galaxy,String>{

	public Galaxy findByName(String name);
}
