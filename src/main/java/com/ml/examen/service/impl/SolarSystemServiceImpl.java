package com.ml.examen.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ml.examen.model.Planet;
import com.ml.examen.model.SolarSystem;
import com.ml.examen.model.bean.ForecastResultBean;
import com.ml.examen.repository.SolarSystemRepository;
import com.ml.examen.service.SolarSystemService;
import com.ml.examen.service.WeatherForecastService;

@Service
public class SolarSystemServiceImpl implements SolarSystemService{
	
	Logger logger = java.util.logging.Logger.getLogger(SolarSystemServiceImpl.class.getName());
	
	
	@Autowired
	SolarSystemRepository solarSystemRepository;

	@Autowired
	WeatherForecastService weatherForecastService;
	
	
	@Override
	public List<SolarSystem> list() throws Exception{
		return solarSystemRepository.findAll();
	}
	
	@Override
	public SolarSystem findByName(String name) throws Exception {
		return solarSystemRepository.findByName(name);
	}


	
	
	@Override
	public List<ForecastResultBean> generateSolarSystemForecastForYears(String solarSystemName, int years) throws Exception{
		SolarSystem solarSystem = this.findByName(solarSystemName);
		int daysToGo = years * 365;
		
		List<ForecastResultBean> predictedForecast = new ArrayList<ForecastResultBean>();
		for (int day = 0; day < daysToGo; day++) {
			predictedForecast.add(simulateSolarSystemForecastDay(solarSystem.getPlanets(), day));
		}
		
		return predictedForecast;
	}
	
	
	
	private ForecastResultBean simulateSolarSystemForecastDay(List<Planet> planets, int day){
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
