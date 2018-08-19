package com.ml.examen.test.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.Assert;
import org.junit.Test;

import com.ml.examen.model.Coordenates;
import com.ml.examen.model.Position;
import com.ml.examen.util.CustomMathUtil;

public class CustomMathUtilTest {

	@Test
	public void areCoordenatesAlligned() throws Exception{
		Position pos1 = new Position(2.00, 1.00);
		Position pos2 = new Position(-4.00, -2.00);
		Position pos3 = new Position(6.00, 3.00);
		Coordenates coordenates = new Coordenates(pos1, pos2, pos3);
		
		Assert.assertTrue(CustomMathUtil.areCoordenatesAlligned(coordenates));
	}
	
	@Test
	public void areCoordenatesAllignedNotSun() throws Exception{
		Position pos1 = new Position(-2.00, 1.00);
		Position pos2 = new Position(4.00, -2.00);
		Coordenates coordenates = new Coordenates(pos1, pos2, new Position(0.00, 0.00));
		
		Assert.assertTrue(CustomMathUtil.areCoordenatesAlligned(coordenates));
	}
	
	@Test
	public void isInside() throws Exception{
		Position pos1 = new Position(0.00, 3.00);
		Position pos2 = new Position(-3.00, -6.00);
		Position pos3 = new Position(3.00, -6.00);
		Position sunPos = new Position(0.00, 0.00);
		Coordenates coordenates = new Coordenates(pos1, pos2, pos3);
		
		Assert.assertTrue(CustomMathUtil.isPositionInsideCoordenates(coordenates, sunPos));
	}
	
	@Test
	public void isNotInside() throws Exception{
		Position pos1 = new Position(0.00, 3.00);
		Position pos2 = new Position(-3.00, -6.00);
		Position pos3 = new Position(-2.00, -6.00);
		Position sunPos = new Position(0.00, 0.00);
		Coordenates coordenates = new Coordenates(pos1, pos2, pos3);
		
		Assert.assertFalse(CustomMathUtil.isPositionInsideCoordenates(coordenates, sunPos));
	}
	
	@Test
	public void testPerimeter() throws Exception{
		Position pos1 = new Position(0.00, 3.00);
		Position pos2 = new Position(-3.00, -6.00);
		Position pos3 = new Position(3.00, -6.00);
		Coordenates coordenates = new Coordenates(pos1, pos2, pos3);
		BigDecimal perim = CustomMathUtil.getCoordenatesPerimeter(coordenates);
		
		Assert.assertEquals( new BigDecimal(24.9738D).setScale(4, RoundingMode.HALF_EVEN)
				, perim.setScale(4, RoundingMode.HALF_EVEN));
	}
	
	
	@Test
	public void testArea() throws Exception{
		Position pos1 = new Position(0.00, 3.00);
		Position pos2 = new Position(-3.00, -6.00);
		Position pos3 = new Position(3.00, -6.00);
		Coordenates coordenates = new Coordenates(pos1, pos2, pos3);
		
		Double area = CustomMathUtil.calculatecoordenatesArea(coordenates);
		Assert.assertEquals(new Double(27.0), area);
	}
}
