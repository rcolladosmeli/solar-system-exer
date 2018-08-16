package com.ml.examen.test;

import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ml.examen.model.WeatherForecast;

public class TestExample extends BaseUnit {

	@Test
	public void testJson() throws Exception{
		WeatherForecast wf = new WeatherForecast();
		wf.setDay(1);
		wf.setStatus("Rain");
		System.out.println(toJson(wf));
	}
	
	
	protected String toJson(Object object){
		Gson gson = new GsonBuilder().create();
		return gson.toJson(object);
	}
	
	protected Object toObject(String json, Object object){
		Gson gson =  new GsonBuilder().create();
		return gson.fromJson(json, object.getClass());
	}
}
