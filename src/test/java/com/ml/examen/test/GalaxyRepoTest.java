package com.ml.examen.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ml.examen.model.Galaxy;
import com.ml.examen.model.Planet;
import com.ml.examen.service.GalaxyService;

public class GalaxyRepoTest extends BaseUnit{

	@Autowired
	GalaxyService galaxyService;
	
	
	@Test
	public void findById() throws Exception{
		Galaxy galaxy = galaxyService.findByName("galaxy");
		
		Assert.assertTrue(galaxy != null);
		for (Planet planet : galaxy.getPlanets()) {
			System.out.println(planet.getName());
			Assert.assertTrue(planet.getName() != null);
		}
	}
	
	@Test
	public void listAll() throws Exception{
		List<Galaxy> galaxies = galaxyService.list();
		
		for (Galaxy galaxy : galaxies) {
			System.out.println(galaxy);	
			System.out.println(galaxy.getPlanets());	
		}
		
		Assert.assertTrue(galaxies.size() >0 );
	}
	
	
}
