package com.ml.examen.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "galaxies")
public class Galaxy {

	@Id
	private String id;
	
	private String name;
	private List<Planet> planets;


	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<Planet> getPlanets() {
		return planets;
	}
	public void setPlanets(List<Planet> planets) {
		this.planets = planets;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
