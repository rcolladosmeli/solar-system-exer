package com.ml.examen.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ml.examen.model.SolarSystem;
import com.ml.examen.model.Planet;
import com.ml.examen.service.SolarSystemService;

public class SolarSystemRepoTest extends BaseUnit{

	@Autowired
	SolarSystemService solarSystemService;
	
	
	@Test
	public void findById() throws Exception{
		SolarSystem solarSystem = solarSystemService.findByName("solarSystem");
		
		Assert.assertTrue(solarSystem != null);
		for (Planet planet : solarSystem.getPlanets()) {
			System.out.println(planet.getName());
			Assert.assertTrue(planet.getName() != null);
		}
	}
	
	@Test
	public void listAll() throws Exception{
		List<SolarSystem> solarSystems = solarSystemService.list();
		
		for (SolarSystem solarSys : solarSystems) {
			System.out.println(solarSys);	
			System.out.println(solarSys.getPlanets());	
		}
		
		Assert.assertTrue(solarSystems.size() >0 );
	}
	
	
}
