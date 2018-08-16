package com.ml.examen.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "planets")
public class Planet {
	
	@Id
	private String id;
	
	private String name;
	private Position position;
	private Double radious;
	private Double angle;
	private Double angularSpeed;
	
	
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
