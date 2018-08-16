package com.ml.examen.service;

import java.util.List;

import com.ml.examen.model.Galaxy;
import com.ml.examen.model.WeatherForecast;

public interface GalaxyService {
	
	public static final String baseUrl = "galaxy";

	public List<Galaxy> list() throws Exception;
	public Galaxy findByName(String name) throws Exception;
	
	
	/**
	 * Generates galaxy forecast prediction for given galaxy and years.
	 * @param galaxy
	 * @param years
	 * @return 
	 * @throws Exception
	 */
	public List<WeatherForecast> generateGalaxyForecastForYears(Galaxy galaxy, int years) throws Exception;
}
