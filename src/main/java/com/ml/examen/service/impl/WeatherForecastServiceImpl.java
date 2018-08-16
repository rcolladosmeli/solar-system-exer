package com.ml.examen.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ml.examen.model.WeatherForecast;
import com.ml.examen.repository.WeatherForecastRepository;
import com.ml.examen.service.WeatherForecastService;

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
	
	
}
