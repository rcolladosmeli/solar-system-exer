package com.ml.examen.config;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ml.examen.model.bean.ForecastResultBean;
import com.ml.examen.service.SolarSystemService;
import com.ml.examen.service.WeatherForecastService;

@Component
public class TaskScheduler {
	
	private static Logger logger = java.util.logging.Logger.getLogger(TaskScheduler.class.getName());
	
	@Autowired
	SolarSystemService solarSystemService;
	
	@Autowired
	WeatherForecastService weatherForecastService;
	
	

    
//    @Scheduled(cron = "0 0/1 * * * *")   schedule puesto para cada 1 miunto para testing
    public void generatePredictionForTenYears() throws Exception{
		try {
			weatherForecastService.deleteAll();
			
			List<ForecastResultBean> results = solarSystemService.generateSolarSystemForecastForYears("solarSystem", 10);
			logger.log(Level.INFO, "FORECASTS GENERATED: "+ results.size());
			
			weatherForecastService.createForecastsFromBean(results);
			logger.log(Level.INFO, "FORECASTS PERSISTED");
		} catch (Exception e) {
			logger.log(Level.SEVERE, "FAILED TO EXECUTE FORECAST JOB", e);
		}
    }
    
}

