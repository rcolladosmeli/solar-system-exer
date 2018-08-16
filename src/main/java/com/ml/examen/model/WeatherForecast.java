package com.ml.examen.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "forecasts")
public class WeatherForecast {

	@Id
	private String id;
	
	private int day;
	private String status;
	
	
	public WeatherForecast() {
		super();
	}

	public WeatherForecast(int day, String status) {
		super();
		this.day = day;
		this.status = status;
	}
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

}
