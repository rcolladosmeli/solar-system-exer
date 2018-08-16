package com.ml.examen.service;

import java.util.List;

import com.ml.examen.model.Galaxy;

public interface GalaxyService {
	
	public static final String baseUrl = "galaxy";

	public List<Galaxy> list() throws Exception;
	public Galaxy findByName(String name) throws Exception;

}
