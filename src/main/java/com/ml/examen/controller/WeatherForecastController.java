package com.ml.examen.controller;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ml.examen.model.WeatherForecast;
import com.ml.examen.service.WeatherForecastService;

@RestController
@RequestMapping(WeatherForecastService.baseUrl)
public class WeatherForecastController {

	Logger logger = java.util.logging.Logger.getLogger(WeatherForecastController.class.getName());
	
	
	@Autowired
	WeatherForecastService weatherForecastService;
	
	
	@PostMapping(consumes= {MediaType.APPLICATION_JSON_VALUE} ,produces = {MediaType.APPLICATION_JSON_VALUE})
	public WeatherForecast create(@RequestBody WeatherForecast weatherForecast) throws Exception{
		return weatherForecastService.create(weatherForecast);
	}
	
	
	@GetMapping(value=WeatherForecastService.byDay, produces = {MediaType.APPLICATION_JSON_VALUE})
	public WeatherForecast findByDay(@PathVariable("day") int day) throws Exception {
		return weatherForecastService.findByDay(day);
	}
	
	@DeleteMapping
	public void deleteSolarSystemForecast() throws Exception {
		 weatherForecastService.deleteAll();
		 logger.log(Level.INFO, "ALL FORECASTS DELETED!");
	}
}
