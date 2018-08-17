package com.ml.examen.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.github.mongobee.Mongobee;

@SpringBootApplication
@ComponentScan(basePackages = { "com.ml.examen"})
@EnableMongoRepositories(basePackages = { "com.ml.examen.model", "com.ml.examen.repository"})
public class SolarSystemExerciseApplication extends SpringBootServletInitializer{

	@Value("${spring.data.mongodb.DB}")
	String dbName;
	
	
	public static void main(String[] args) {
		SpringApplication.run(SolarSystemExerciseApplication.class, args);
	}
	
	
	@Bean
	public Mongobee mongobee(){
	  Mongobee runner = new Mongobee("mongodb://localhost:27017/"+dbName);
	  runner.setDbName(dbName);  
	  runner.setChangeLogsScanPackage("com.ml.examen.changelog");
	  
	  return runner;
	}	
}
