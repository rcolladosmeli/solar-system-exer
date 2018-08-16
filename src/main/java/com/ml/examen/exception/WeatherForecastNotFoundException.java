package com.ml.examen.exception;

public class WeatherForecastNotFoundException extends Exception {

	private static final long serialVersionUID = 8542111763123581066L;

	public WeatherForecastNotFoundException() {
		super();
	}

	public WeatherForecastNotFoundException(String message) {
		super(message);
	}
	
	public WeatherForecastNotFoundException(Throwable cause) { 
		super();
	}
	
	public WeatherForecastNotFoundException(String message, Throwable cause){
		super(message);
	}
}
