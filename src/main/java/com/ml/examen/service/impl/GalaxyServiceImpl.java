package com.ml.examen.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ml.examen.model.Galaxy;
import com.ml.examen.model.Planet;
import com.ml.examen.model.WeatherForecast;
import com.ml.examen.repository.GalaxyRepository;
import com.ml.examen.service.GalaxyService;
import com.ml.examen.service.WeatherForecastService;

@Service
public class GalaxyServiceImpl implements GalaxyService{
	
	Logger logger = java.util.logging.Logger.getLogger(GalaxyServiceImpl.class.getName());
	
	
	@Autowired
	GalaxyRepository galaxyRepository;

	@Autowired
	WeatherForecastService weatherForecastService;
	
	
	
	@Override
	public List<Galaxy> list() throws Exception{
		return galaxyRepository.findAll();
	}
	
	@Override
	public Galaxy findByName(String name) throws Exception {
		return galaxyRepository.findByName(name);
	}
	
	
	
	@Override
	public List<WeatherForecast> generateGalaxyForecastForYears(Galaxy galaxy, int years){
		List<WeatherForecast> predictedForecast = new ArrayList<WeatherForecast>();
		
		int daysToGo = years * 365;
		
		for (int day = 0; day < daysToGo; day++) {
			predictedForecast.add(simulateGalaxyForecastDay(galaxy.getPlanets(), day));
		}
		
		return predictedForecast;
	}
	
	
	
	private WeatherForecast simulateGalaxyForecastDay(List<Planet> planets, int day){
		try {
			for (Planet planet : planets) {
				planet.movePlanetForDay();
			}

			return weatherForecastService.generateForecast(planets.get(0), planets.get(1), planets.get(2), day);
		} catch (Exception e) {
			logger.log(Level.SEVERE, "FAILED TO GENERATE FORECAST", e);
		}
		
		return null;
	}
}
