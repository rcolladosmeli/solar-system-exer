package com.ml.examen.service;

import java.util.List;

import com.ml.examen.model.SolarSystem;
import com.ml.examen.model.WeatherForecast;

public interface SolarSystemService {
	
	public static final String baseUrl = "solar-system";
	public static final String forecastUrl =  "/{solarSystemName}/{years}";

	public List<SolarSystem> list() throws Exception;
	public SolarSystem findByName(String name) throws Exception;
	
	
	/**
	 * Generates solarSystem forecast prediction for given solarSystem and years.
	 * @param solarSystem
	 * @param years
	 * @return 
	 * @throws Exception
	 */
	public List<WeatherForecast> generateSolarSystemForecastForYears(String solarSystemName, int years) throws Exception;
}
