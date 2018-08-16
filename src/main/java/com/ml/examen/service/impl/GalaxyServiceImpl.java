package com.ml.examen.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ml.examen.model.Galaxy;
import com.ml.examen.repository.GalaxyRepository;
import com.ml.examen.service.GalaxyService;

@Service
public class GalaxyServiceImpl implements GalaxyService{
	
	@Autowired
	GalaxyRepository galaxyRepository;

	@Override
	public List<Galaxy> list() throws Exception{
		return galaxyRepository.findAll();
	}
	
	@Override
	public Galaxy findByName(String name) throws Exception {
		return galaxyRepository.findByName(name);
	}
	
}
