package com.ml.examen.service;

import java.util.List;

import com.ml.examen.model.Planet;
import com.ml.examen.model.WeatherForecast;
import com.ml.examen.model.WeatherForecastSummary;
import com.ml.examen.model.bean.ForecastResultBean;

public interface WeatherForecastService {

	public static final String baseUrl = "weatherforecast";
	public static final String byDay = "/{day}";
	
	
	public WeatherForecast create(WeatherForecast weatherForecast) throws Exception;
	public WeatherForecast findByDay(int day) throws Exception;
	public void deleteAll() throws Exception;
	public List<WeatherForecast> createForecasts(List<WeatherForecast> forecasts) throws Exception;
	public List<WeatherForecast> createForecastsFromBean(List<ForecastResultBean> forecasts) throws Exception;
	
	
	/**
	 * Generates forecast bean for 3 planets.
	 * @param planetA
	 * @param planetB
	 * @param planetC
	 * @param day 
	 * @return
	 * @throws Exception
	 */
	public ForecastResultBean generateForecast(Planet planetA, Planet planetB, Planet planetC, int day) throws Exception;
	
	
	/**
	 * Generates forecast summary.
	 * @param forecasts
	 * @return
	 * @throws Exception
	 */
	public WeatherForecastSummary generateForecastSummary(List<ForecastResultBean> forecastBeans) throws Exception;

}
