package com.ml.examen.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Position {
	private double x;
	private double y;
	
	
	
	public Position() {
		super();
	}

	public Position(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	
	
	public static BigDecimal getDistanceBetween(Position pos1, Position pos2) {
		Double distance = Math.sqrt(Math.pow((pos2.getX()-pos1.getX()),2) + Math.pow((pos2.getY()-pos1.getY()),2));
		return new BigDecimal(distance).setScale(4, RoundingMode.UP);
	}
}
