package com.ml.examen.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.ml.examen.model.Position;
  import com.ml.examen.model.Coordenates;

public class CustomMathUtil {
	
	//Si restamos sus lados y da 0 entonces estan alineados
	public static Boolean areCoordenatesAlligned(Coordenates coordenates) {
		Double x1 = coordenates.getPositionA().getX();
		Double y1 = coordenates.getPositionA().getY();
		Double x2 = coordenates.getPositionB().getX();
		Double y2 = coordenates.getPositionB().getY();
		Double x3 = coordenates.getPositionC().getX();
		Double y3 = coordenates.getPositionC().getY();
		
		if (((x2-x1)*(y3-y2))-((y2-y1)*(x3-x2)) == 0.00){
			return true;
		}
		
		return false;
	}
	
	
	public static BigDecimal getCoordenatesPerimeter(Coordenates coordenates) {
		BigDecimal AB = Position.getDistanceBetween(coordenates.getPositionA(), coordenates.getPositionB());
		BigDecimal AC = Position.getDistanceBetween(coordenates.getPositionA(), coordenates.getPositionC());
		BigDecimal BC = Position.getDistanceBetween(coordenates.getPositionB(), coordenates.getPositionC());
		return AB.add(AC).add(BC).setScale(4, RoundingMode.UP);
	}
	
	
	public static Double calculatecoordenatesArea(Coordenates coordenates) throws Exception {
		Double x1 = coordenates.getPositionA().getX();
		Double y1 = coordenates.getPositionA().getY();
		Double x2 = coordenates.getPositionB().getX();
		Double y2 = coordenates.getPositionB().getY();
		Double x3 = coordenates.getPositionC().getX();
		Double y3 = coordenates.getPositionC().getY();
		
		return Math.abs((x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2)) / 2.0);
		
	}
	
	// Si la sumatoria de las areas de los triangulos que forman con el sol es igual al el area entre ellos entonces esta adentro.
	public static Boolean isPositionInsideCoordenates(Coordenates coordenates, Position position) throws Exception {
		Coordenates coordenatesPositionA = new Coordenates(coordenates.getPositionB(), coordenates.getPositionC(), position);
		Coordenates coordenatesPositionB = new Coordenates(coordenates.getPositionA(), coordenates.getPositionC(), position);
		Coordenates coordenatesPositionC = new Coordenates(coordenates.getPositionA(), coordenates.getPositionB(), position);
		
		Double A = calculatecoordenatesArea(coordenates);
		Double A1 = calculatecoordenatesArea(coordenatesPositionA);
		Double A2 = calculatecoordenatesArea(coordenatesPositionB);
		Double A3 = calculatecoordenatesArea(coordenatesPositionC);
		return (A == A1 + A2 + A3);
	}
	

}
