package com.proyectoIntegrado.service;

import java.util.List;

import com.proyectoIntegrado.model.Aptitud;

public interface AptitudService {
	List<Aptitud> getAptitudes();
	Aptitud save(Aptitud aptitud);
}
