package com.ml.examen.exception.controller;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.ml.examen.exception.WeatherForecastNotFoundException;

@ControllerAdvice
public class WeatherForecastExceptionController {

	Logger logger = java.util.logging.Logger.getLogger(WeatherForecastExceptionController.class.getName());
	
	@ExceptionHandler(WeatherForecastNotFoundException.class)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void weatherForecastNotFoundException(WeatherForecastNotFoundException ex){
		logger.log(Level.SEVERE, ex.getMessage(), ex);
	}
}
