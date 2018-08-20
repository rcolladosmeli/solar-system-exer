package com.ml.examen.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.github.mongobee.Mongobee;
import com.mongodb.MongoClient;

@Configuration
@EnableMongoRepositories(basePackages = { "com.ml.examen.model", "com.ml.examen.repository"})
@ConfigurationProperties(prefix="spring.data.mongodb")
public class MongoConfig extends AbstractMongoConfiguration {

	@Value("${spring.data.mongodb.database}")
	String dbName;
	
	@Value("${spring.data.mongodb.host}")
	String host;
	
	@Value("${spring.data.mongodb.port}")
	String port;
	
	@Value("${spring.data.mongodb.uri}")
	String uri;


	@Override
	public MongoClient mongoClient() {
		return new MongoClient(uri);
	}

	@Override
	protected String getDatabaseName() {
		return dbName;
	}
	
	
	@Bean
	public Mongobee mongobee(){
	  Mongobee runner = new Mongobee(uri);
	  
//	  runner.setDbName(dbName);  
	  runner.setChangeLogsScanPackage("com.ml.examen.changelog");
	  
	  return runner;
	}	

}
