package com.ml.examen.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ml.examen.model.Coordenates;
import com.ml.examen.model.Planet;
import com.ml.examen.model.Position;
import com.ml.examen.model.WeatherForecast;
import com.ml.examen.repository.WeatherForecastRepository;
import com.ml.examen.service.WeatherForecastService;
import com.ml.examen.util.CustomMathUtil;

@Service
public class WeatherForecastServiceImpl implements WeatherForecastService{

	@Autowired
	WeatherForecastRepository weatherForecastRepository;

	
	
	@Override
	public WeatherForecast create(WeatherForecast weatherForecast) throws Exception{
		return weatherForecastRepository.insert(weatherForecast);
	}


	@Override
	public WeatherForecast findByDay(int day) throws Exception {
		return weatherForecastRepository.findByDay(day);
	}
	
	
	@Override
	public WeatherForecast generateForecast(Planet planetA, Planet planetB, Planet planetC, int day) throws Exception{
		WeatherForecast forecast = new WeatherForecast();
		forecast.setDay(day);
		
		Coordenates planetsCoordenates = new Coordenates(planetA.getPosition(),
															planetB.getPosition(),
															planetC.getPosition());
		
		
		//LLUVIA
		if(CustomMathUtil.areCoordenatesAlligned(planetsCoordenates)){
			
		}
		
		//LLUVIA
		if(CustomMathUtil.isPositionInsideCoordenates(planetsCoordenates, new Position(0,0))){
			
		}

		return forecast;
	}
	
	
	
}
