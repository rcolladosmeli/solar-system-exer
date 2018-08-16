package com.ml.examen.service;

import com.ml.examen.model.WeatherForecast;

public interface WeatherForecastService {

	public static final String baseUrl = "weatherforecast";
	public static final String byDay = "/{day}";
	
	
	public WeatherForecast create(WeatherForecast weatherForecast) throws Exception;
	public WeatherForecast findByDay(int day) throws Exception;
}
