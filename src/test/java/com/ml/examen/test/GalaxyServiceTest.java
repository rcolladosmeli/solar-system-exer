package com.ml.examen.test;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ml.examen.model.Galaxy;
import com.ml.examen.model.WeatherForecast;
import com.ml.examen.service.GalaxyService;
import com.ml.examen.service.WeatherForecastService;

public class GalaxyServiceTest extends BaseUnit{

	@Autowired
	GalaxyService galaxyService;
	
	@Autowired
	WeatherForecastService weatherForecastService;
	
	
	@Test
	public void testForecast() throws Exception{
		Galaxy galaxy = galaxyService.findByName("galaxy");
		
		List<WeatherForecast> forecasts = galaxyService.generateGalaxyForecastForYears(galaxy, 10);
		for (WeatherForecast wf : forecasts) {
			if(wf != null){
				System.out.println(wf.getDay() + "  " + wf.getStatus());
			}
		}
	}
	
	
	@Test
	public void testForecastMassiveInsert() throws Exception{
		Galaxy galaxy = galaxyService.findByName("galaxy");
		
		List<WeatherForecast> forecasts = galaxyService.generateGalaxyForecastForYears(galaxy, 10);
		for (WeatherForecast wf : forecasts) {
			if(wf != null){
				System.out.println("CREATING   " + wf.getDay() + "  " + wf.getStatus());
				weatherForecastService.create(wf);
			}
		}
	}
}
