package com.ml.examen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ml.examen.model.bean.ForecastResultBean;
import com.ml.examen.service.SolarSystemService;
import com.ml.examen.service.WeatherForecastService;

@RestController
@RequestMapping(SolarSystemService.baseUrl)
public class SolarSystemController {
	
	@Autowired
	SolarSystemService solarSystemService;
	
	@Autowired
	WeatherForecastService weatherForecastService;
	

	@PostMapping(value = SolarSystemService.forecastUrl, produces = {MediaType.APPLICATION_JSON_VALUE})
	public void generateSolarSystemForecastForYears(@PathVariable("solarSystemName") String solarSystemName, 
													@PathVariable("years") int years) throws Exception{
		
		List<ForecastResultBean> forecastBeans = solarSystemService.generateSolarSystemForecastForYears(solarSystemName, years);
		weatherForecastService.createForecastsFromBean(forecastBeans);
	}
}
