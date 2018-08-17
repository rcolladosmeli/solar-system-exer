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

	private Position sunPos = new Position(0,0);
	
	
	@Override
	public WeatherForecast create(WeatherForecast weatherForecast) throws Exception{
		return weatherForecastRepository.insert(weatherForecast);
	}


	@Override
	public WeatherForecast findByDay(int day) throws Exception {
		return weatherForecastRepository.findByDay(day);
	}
	
	
	@Override
	public void deleteAll() throws Exception{
		weatherForecastRepository.deleteAll();
	}
	
	
	
	@Override 
	public WeatherForecast generateForecast(Planet planetA, Planet planetB, Planet planetC, int day) throws Exception{
		Coordenates planetsCoordenates = new Coordenates(planetA.getPosition(),
															planetB.getPosition(),
															planetC.getPosition());
		
		Coordenates planetsCoordenatesWithSun = new Coordenates(planetA.getPosition(),
																	planetB.getPosition(),
																	sunPos);
		
		//SEQUIA - cuando estan alineados y tambien con el sol
		if(CustomMathUtil.areCoordenatesAlligned(planetsCoordenates) && 
				CustomMathUtil.areCoordenatesAlligned(planetsCoordenatesWithSun) ){
			return new WeatherForecast(day, "DROUGHT");
		}
		
		//LLUVIA - cuando forman un triangulo alrededor del sol
		if(CustomMathUtil.isPositionInsideCoordenates(planetsCoordenates, sunPos)){ 
			return new WeatherForecast(day, "RAIN");
		}
		
		//OPTIMAL - cuando estan alineados entre si pero no con el sol
		if(CustomMathUtil.areCoordenatesAlligned(planetsCoordenates)){
			return new WeatherForecast(day, "OPTIMAL");
		}
		
		return new WeatherForecast(day, "NORMAL");
	}
	
	
	
}
