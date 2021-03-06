package com.ml.examen.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "planets")
public class Planet {
	
	private static final double TWO_RADIANS = 360.00;
	
	
	@Id
	private String id;
	
	private String name;
	private Position position;
	private Double radious;
	private Double angle;
	private Double angularSpeed; //Daily
	
	
	public void movePlanetForDay() {
		Double auxAngle = this.angle + this.angularSpeed;
		
		if (auxAngle > 0 && auxAngle >= TWO_RADIANS){
			auxAngle-=TWO_RADIANS;
		}
		
		if (auxAngle < 0 && auxAngle <= -TWO_RADIANS){
			auxAngle+=TWO_RADIANS;
		}
		
		Double x = new BigDecimal(this.getRadious() * Math.cos(Math.toRadians(auxAngle))).setScale(2, RoundingMode.UP).doubleValue();
		Double y = new BigDecimal(this.getRadious() * Math.sin(Math.toRadians(auxAngle))).setScale(2, RoundingMode.UP).doubleValue();
		
		updatePositionAndAngle(auxAngle, x, y);
	}
	
	
	private void updatePositionAndAngle(Double angleTmp, Double x, Double y) {
		this.position.setX(x);
		this.position.setY(y);
		this.setAngle(angleTmp);
	}




	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Position getPosition() {
		return position;
	}
	public void setPosition(Position positiion) {
		this.position = positiion;
	}
	public Double getRadious() {
		return radious;
	}
	public void setRadious(Double radious) {
		this.radious = radious;
	}
	public Double getAngle() {
		return angle;
	}
	public void setAngle(Double angle) {
		this.angle = angle;
	}
	public Double getAngularSpeed() {
		return angularSpeed;
	}
	public void setAngularSpeed(Double angularSpeed) {
		this.angularSpeed = angularSpeed;
	}
}
