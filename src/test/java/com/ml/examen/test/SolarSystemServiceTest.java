package com.ml.examen.test;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ml.examen.model.WeatherForecast;
import com.ml.examen.service.SolarSystemService;
import com.ml.examen.service.WeatherForecastService;

public class SolarSystemServiceTest extends BaseUnit{

	@Autowired
	SolarSystemService solarSystemService;
	
	@Autowired
	WeatherForecastService weatherForecastService;
	
	
	@Test
	public void testForecast() throws Exception{
		
		List<WeatherForecast> forecasts = solarSystemService.generateSolarSystemForecastForYears("solarSystem", 10);
		for (WeatherForecast wf : forecasts) {
			if(wf != null){
				System.out.println(wf.getDay() + "  " + wf.getStatus());
			}
		}
	}
	
	
	@Test
	public void testForecastMassiveInsert() throws Exception{
		
		List<WeatherForecast> forecasts = solarSystemService.generateSolarSystemForecastForYears("solarSystem", 10);
		for (WeatherForecast wf : forecasts) {
			if(wf != null){
				System.out.println("CREATING   " + wf.getDay() + "  " + wf.getStatus());
				weatherForecastService.create(wf);
			}
		}
	}
}
