package com.ml.examen.model.enums;

public enum ForecastStatusEnum {
	
	RAIN("RAIN"),
	OPTIMAL("OPTIMAL"),
	DROUGHT("DROUGHT"),
	NORMAL("NORMAL");
	
	
	private String status;
	
	private ForecastStatusEnum(String status){
		this.status = status;
	}
	
	public String value(){
		return status;
	}
}
