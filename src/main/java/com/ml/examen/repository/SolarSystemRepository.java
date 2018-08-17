package com.ml.examen.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ml.examen.model.SolarSystem;

public interface SolarSystemRepository extends MongoRepository<SolarSystem,String>{

	public SolarSystem findByName(String name);
}
