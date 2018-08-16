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
		
		//LLUVIA - cuando estan alineados (No con el sol) o forman un triangulo alrededor del sol
		if(CustomMathUtil.areCoordenatesAlligned(planetsCoordenates) || CustomMathUtil.isPositionInsideCoordenates(planetsCoordenates, sunPos)){ 
			return new WeatherForecast(day, "RAIN");
		}
		
		//OPTIMAL - cuando nadie esta alineado entre si
		if(validateOptimal(planetsCoordenates)){
			return new WeatherForecast(day, "OPTIMAL");
		}
			
		return null;
	}
	
	
	
	private Boolean validateOptimal(Coordenates coordenates){
		Coordenates ABSun = new Coordenates(coordenates.getPositionA(),
											coordenates.getPositionB(),
											sunPos);
		
		Coordenates ACSun = new Coordenates(coordenates.getPositionA(),
											sunPos,
											coordenates.getPositionC());
		
		Coordenates BCSun = new Coordenates(sunPos,
											coordenates.getPositionB(),
											coordenates.getPositionC());

		
		return (!CustomMathUtil.areCoordenatesAlligned(ABSun) && 
				!CustomMathUtil.areCoordenatesAlligned(ACSun) && 
				!CustomMathUtil.areCoordenatesAlligned(BCSun));
	}
	
}
