package com.ml.examen.repository;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.ml.examen.model.WeatherForecast;

public interface WeatherForecastRepository extends MongoRepository<WeatherForecast,Long>{

	public WeatherForecast findByDay(int day);
}
