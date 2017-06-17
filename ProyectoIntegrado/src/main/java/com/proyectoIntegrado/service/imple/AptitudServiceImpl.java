package com.proyectoIntegrado.service.imple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectoIntegrado.model.Aptitud;
import com.proyectoIntegrado.repository.AptitudRepository;
import com.proyectoIntegrado.service.AptitudService;

@Service
public class AptitudServiceImpl implements AptitudService {

	private AptitudRepository aptitudRepository;

	@Autowired
	public AptitudServiceImpl(AptitudRepository aptitudRepository) {
		this.aptitudRepository = aptitudRepository;
	}

	@Override
	public List<Aptitud> getAptitudes() {
		return aptitudRepository.findAll();
	}

	@Override
	public Aptitud save(Aptitud aptitud) {
		return aptitudRepository.save(aptitud);
	}
}
