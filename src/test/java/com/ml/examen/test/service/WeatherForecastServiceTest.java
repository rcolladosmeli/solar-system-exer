package com.ml.examen.test.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ml.examen.model.WeatherForecastSummary;
import com.ml.examen.model.bean.ForecastResultBean;
import com.ml.examen.service.SolarSystemService;
import com.ml.examen.service.WeatherForecastService;
import com.ml.examen.test.BaseUnit;

public class WeatherForecastServiceTest extends BaseUnit{

	@Autowired
	WeatherForecastService weatherForecastService;
	
	@Autowired
	SolarSystemService solarSystemService;
	
	
	@Test
	public void generateForecastSummary() throws Exception{
		List<ForecastResultBean> forecasts = solarSystemService.generateSolarSystemForecastForYears("solarSystem", 10);
		
		WeatherForecastSummary summary = weatherForecastService.generateForecastSummary(forecasts);
		
		Assert.assertTrue(summary.getDroughtPeriods() >0);
		Assert.assertTrue(summary.getRainPeriods() >0);
		Assert.assertTrue(summary.getOptimalPeriods() == 0);
		Assert.assertTrue(summary.getNormalPeriods() > 0);
		Assert.assertTrue(summary.getMaxRainDay() >0);
		
		System.out.println(summary.getDroughtPeriods());
		System.out.println(summary.getNormalPeriods());
		System.out.println(summary.getOptimalPeriods());
		System.out.println(summary.getRainPeriods());
		System.out.println(summary.getMaxRainDay());
		
		System.out.println(forecasts.size());
	}
}
