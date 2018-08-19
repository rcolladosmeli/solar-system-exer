package com.ml.examen.model.bean;

import java.util.List;

import com.ml.examen.model.Coordenates;
import com.ml.examen.model.Planet;
import com.ml.examen.model.WeatherForecast;

public class ForecastResultBean {

	private WeatherForecast forecast;
	private List<Planet> planets;
	private Coordenates planetsCoordenates;
	
	
	public ForecastResultBean(WeatherForecast forecast, List<Planet> planets, int day, Coordenates coordenates) {
		super();
		this.forecast = forecast;
		this.planets = planets;
		this.planetsCoordenates = coordenates;
	}
	
	
	public WeatherForecast getForecast() {
		return forecast;
	}
	public void setForecast(WeatherForecast forecast) {
		this.forecast = forecast;
	}
	public List<Planet> getPlanets() {
		return planets;
	}
	public void setPlanets(List<Planet> planets) {
		this.planets = planets;
	}

	public Coordenates getPlanetsCoordenates() {
		return planetsCoordenates;
	}

	public void setPlanetsCoordenates(Coordenates planetsCoordenates) {
		this.planetsCoordenates = planetsCoordenates;
	}
}
