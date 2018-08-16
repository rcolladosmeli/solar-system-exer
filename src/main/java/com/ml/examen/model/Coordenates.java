package com.ml.examen.model;

public class Coordenates {
	private Position positionA;
	private Position positionB;
	private Position positionC;
	
	
	public Coordenates() {
		super();
	}
	
	public Coordenates(Position positionA, Position positionB, Position positionC) {
		super();
		this.positionA = positionA;
		this.positionB = positionB;
		this.positionC = positionC;
	}
	
	public Position getPositionA() {
		return positionA;
	}
	public void setPositionA(Position positionA) {
		this.positionA = positionA;
	}
	public Position getPositionB() {
		return positionB;
	}
	public void setPositionB(Position positionB) {
		this.positionB = positionB;
	}
	public Position getPositionC() {
		return positionC;
	}
	public void setPositionC(Position positionC) {
		this.positionC = positionC;
	}
}
