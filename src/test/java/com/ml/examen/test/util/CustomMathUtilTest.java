package com.ml.examen.test.util;

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
}
