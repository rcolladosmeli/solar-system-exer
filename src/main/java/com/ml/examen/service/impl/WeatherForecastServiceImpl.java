package com.ml.examen.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ml.examen.exception.WeatherForecastNotFoundException;
import com.ml.examen.model.Coordenates;
import com.ml.examen.model.Planet;
import com.ml.examen.model.Position;
import com.ml.examen.model.WeatherForecast;
import com.ml.examen.model.WeatherForecastSummary;
import com.ml.examen.model.bean.ForecastResultBean;
import com.ml.examen.model.enums.ForecastStatusEnum;
import com.ml.examen.repository.WeatherForecastRepository;
import com.ml.examen.service.WeatherForecastService;
import com.ml.examen.util.CustomMathUtil;

@Service
public class WeatherForecastServiceImpl implements WeatherForecastService{

	private static Logger logger = java.util.logging.Logger.getLogger(WeatherForecastServiceImpl.class.getName());
	
	
	
	@Autowired
	WeatherForecastRepository weatherForecastRepository;

	private Position sunPos = new Position(0,0);
	
	
	@Override
	public WeatherForecast create(WeatherForecast weatherForecast) throws Exception{
		return weatherForecastRepository.insert(weatherForecast);
	}


	@Override
	public WeatherForecast findByDay(int day) throws Exception {
		WeatherForecast wf = weatherForecastRepository.findByDay(day);
		if(wf != null){
			return wf;
		}else{
			throw new WeatherForecastNotFoundException();
		}
	}
	
	
	@Override
	public void deleteAll() throws Exception{
		weatherForecastRepository.deleteAll();
	}
	
	@Override
	public List<WeatherForecast> createForecasts(List<WeatherForecast> forecasts) throws Exception{
		if(forecasts != null && forecasts.size()>0){
			for (WeatherForecast wf : forecasts) {
				this.create(wf);
				logger.log(Level.INFO, "WEATHER FORECAST FOR DAY: "+wf.getDay()+" CREATED");
			}
		}
		
		return forecasts;
	}

	@Override
	public List<WeatherForecast> createForecastsFromBean(List<ForecastResultBean> forecasts) throws Exception{
		List<WeatherForecast> wfs = new ArrayList<>();
		if(forecasts != null && forecasts.size()>0){
			for (ForecastResultBean bean : forecasts) {
				this.create(bean.getForecast());
				wfs.add(bean.getForecast());
				logger.log(Level.INFO, "WEATHER FORECAST FOR DAY: "+bean.getForecast().getDay()+" CREATED");
			}
		}
		
		return wfs;
	}

	
	@Override 
	public ForecastResultBean generateForecast(Planet planetA, Planet planetB, Planet planetC, int day) throws Exception{
		
		Coordenates planetsCoordenates = new Coordenates(planetA.getPosition(),
															planetB.getPosition(),
															planetC.getPosition());

		WeatherForecast forecast = resolveForecastConditions(day, planetsCoordenates);
		List<Planet> planets = new ArrayList<>();
		planets.add(planetA);
		planets.add(planetB);
		planets.add(planetC);
		
		return  new ForecastResultBean(forecast, planets, day, planetsCoordenates);
	}
	
	
	
	private WeatherForecast resolveForecastConditions(int day, Coordenates planetsCoordenates) {
		
		Coordenates planetsCoordenatesWithSun = new Coordenates(planetsCoordenates.getPositionA(),
																planetsCoordenates.getPositionB(),
																sunPos);

		WeatherForecast forecast =  new WeatherForecast(day, ForecastStatusEnum.NORMAL.value());
		//SEQUIA - cuando estan alineados y tambien con el sol
		try {
			if(CustomMathUtil.areCoordenatesAlligned(planetsCoordenates) && 
							CustomMathUtil.areCoordenatesAlligned(planetsCoordenatesWithSun) ){
				return new WeatherForecast(day, ForecastStatusEnum.DROUGHT.value());
			}
			
			//LLUVIA - cuando forman un triangulo alrededor del sol
			if(CustomMathUtil.isPositionInsideCoordenates(planetsCoordenates, sunPos)){ 
				return new WeatherForecast(day, ForecastStatusEnum.RAIN.value());
			}
			
			//OPTIMAL - cuando estan alineados entre si pero no con el sol
			if(CustomMathUtil.areCoordenatesAlligned(planetsCoordenates)){
				return new WeatherForecast(day, ForecastStatusEnum.OPTIMAL.value());
			}
		} catch (Exception e) {
			logger.log(Level.SEVERE, "FORECAST CONDITION EVALUATION FAILED FOR DAY: "+ day, e);
		}
		
		return forecast;
	}

	
	@Override
	public WeatherForecastSummary generateForecastSummary(List<ForecastResultBean> forecastBeans) throws Exception{
		WeatherForecastSummary summary = new WeatherForecastSummary();
		summary.setNormalPeriods(resolveConditionPeriods(forecastBeans, ForecastStatusEnum.NORMAL.value()));
		summary.setRainPeriods(resolveConditionPeriods(forecastBeans, ForecastStatusEnum.RAIN.value()));
		summary.setOptimalPeriods(resolveConditionPeriods(forecastBeans, ForecastStatusEnum.OPTIMAL.value()));
		summary.setDroughtPeriods(resolveConditionPeriods(forecastBeans, ForecastStatusEnum.DROUGHT.value()));
		
		summary.setMaxRainDay(resolveMaxRainDay(forecastBeans));
		
		return summary;
	}
	
	private int resolveMaxRainDay(List<ForecastResultBean> forecastBeans) throws Exception {
		List<ForecastResultBean> rainBeans = new ArrayList<ForecastResultBean>();
		
		for (ForecastResultBean bean : forecastBeans) {
			if(bean.getForecast().getStatus().equals(ForecastStatusEnum.RAIN.value())){
				rainBeans.add(bean);
			}
		}
		
		Double auxArea = 0D;
		int dayMaxRain = 0;
		for (ForecastResultBean bean : rainBeans) {
			Double area = CustomMathUtil.calculatecoordenatesArea(bean.getPlanetsCoordenates());
			if(area > auxArea){
				dayMaxRain = bean.getForecast().getDay();
			}
				
			auxArea = area;
		}
		
		return dayMaxRain;
	}


	private int resolveConditionPeriods(List<ForecastResultBean> forecastBeans, String status){
		int periods = 0;

		String previousStatus = "";
		for (ForecastResultBean bean : forecastBeans) {
			String beanStatus = bean.getForecast().getStatus();
			if(beanStatus.equals(status) && !beanStatus.equals(previousStatus)){
				periods++;
			}

			previousStatus = bean.getForecast().getStatus();
		}
		
		return periods;
	}
}
