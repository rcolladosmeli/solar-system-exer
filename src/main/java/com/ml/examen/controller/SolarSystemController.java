package com.ml.examen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ml.examen.service.SolarSystemService;

@RestController
@RequestMapping(SolarSystemService.baseUrl)
public class SolarSystemController {
	
	@Autowired
	SolarSystemService solarSystemService;
	

	@PostMapping(value = SolarSystemService.forecastUrl, produces = {MediaType.APPLICATION_JSON_VALUE})
	public void generateSolarSystemForecastForYears(@PathVariable("solarSystemName") String solarSystemName, 
													@PathVariable("years") int years) throws Exception{
		
		solarSystemService.generateSolarSystemForecastForYears(solarSystemName, years);
	}
}
