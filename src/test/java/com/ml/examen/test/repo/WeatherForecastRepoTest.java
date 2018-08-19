package com.ml.examen.test.repo;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ml.examen.model.WeatherForecast;
import com.ml.examen.service.WeatherForecastService;
import com.ml.examen.test.BaseUnit;

public class WeatherForecastRepoTest extends BaseUnit{

	@Autowired
	WeatherForecastService weatherForecastService;
	
	@Test
	public void testCreate() throws Exception{
		WeatherForecast wf = new WeatherForecast();
		wf.setDay(1);
		wf.setStatus("Rain");
		
		weatherForecastService.create(wf);
	}
	
	@Test
	public void testFindByDay() throws Exception{
		WeatherForecast wf = weatherForecastService.findByDay(1);
		System.out.println(wf.getStatus());
		
		Assert.assertTrue(wf != null);
	}
}
