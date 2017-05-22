package com.proyectoIntegrado.service;

import java.util.List;

import com.proyectoIntegrado.model.Ciclo;

public interface CicloService {

	List<Ciclo> getCiclos();
	Ciclo getCiclo(String siglas);
}
