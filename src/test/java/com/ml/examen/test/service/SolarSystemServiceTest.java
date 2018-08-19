package com.ml.examen.test.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ml.examen.model.bean.ForecastResultBean;
import com.ml.examen.model.enums.ForecastStatusEnum;
import com.ml.examen.service.SolarSystemService;
import com.ml.examen.service.WeatherForecastService;
import com.ml.examen.test.BaseUnit;

public class SolarSystemServiceTest extends BaseUnit{

	@Autowired
	SolarSystemService solarSystemService;
	
	@Autowired
	WeatherForecastService weatherForecastService;
	
	
	@Test
	public void testForecast() throws Exception{
		
		List<ForecastResultBean> forecasts = solarSystemService.generateSolarSystemForecastForYears("solarSystem", 10);
		for (ForecastResultBean bean : forecasts) {
			if(bean != null){
				System.out.println(bean.getForecast().getDay() + "  " + bean.getForecast().getStatus());
			}
		}
	}
	
	
	@Test
	public void checkOptimal() throws Exception{
		
		List<ForecastResultBean> forecasts = solarSystemService.generateSolarSystemForecastForYears("solarSystem", 30);
		for (ForecastResultBean bean : forecasts) {
			if(bean.getForecast().getStatus().equals(ForecastStatusEnum.OPTIMAL.value())){
				System.out.println(bean.getForecast().getDay() + "  " + bean.getForecast().getStatus());
			}
		}
	}
	
	
	@Test
	public void testForecastMassiveInsert() throws Exception{
		List<ForecastResultBean> forecasts = solarSystemService.generateSolarSystemForecastForYears("solarSystem", 10);
		for (ForecastResultBean bean : forecasts) {
			if(bean != null){
				System.out.println("CREATING   " + bean.getForecast().getDay() + "  " + bean.getForecast().getDay());
				weatherForecastService.create(bean.getForecast());
			}
		}
	}
}
