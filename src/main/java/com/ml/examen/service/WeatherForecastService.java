package com.ml.examen.service;

import com.ml.examen.model.Planet;
import com.ml.examen.model.WeatherForecast;

public interface WeatherForecastService {

	public static final String baseUrl = "weatherforecast";
	public static final String byDay = "/{day}";
	
	
	public WeatherForecast create(WeatherForecast weatherForecast) throws Exception;
	public WeatherForecast findByDay(int day) throws Exception;
	public void deleteAll() throws Exception;
	
	/**
	 * Generates forecast for 3 planets.
	 * @param planetA
	 * @param planetB
	 * @param planetC
	 * @param day 
	 * @return
	 * @throws Exception
	 */
	public WeatherForecast generateForecast(Planet planetA, Planet planetB, Planet planetC, int day) throws Exception;

}
