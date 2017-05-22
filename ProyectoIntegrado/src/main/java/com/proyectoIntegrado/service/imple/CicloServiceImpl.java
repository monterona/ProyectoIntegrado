package com.proyectoIntegrado.service.imple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectoIntegrado.model.Ciclo;
import com.proyectoIntegrado.repository.CicloRepository;
import com.proyectoIntegrado.service.CicloService;

@Service
public class CicloServiceImpl implements CicloService {

	private CicloRepository cicloRepository;

	@Autowired
	public CicloServiceImpl(CicloRepository cicloRepository) {
		this.cicloRepository = cicloRepository;
	}

	@Override
	public List<Ciclo> getCiclos() {
		return cicloRepository.findAll();
	}

	@Override
	public Ciclo getCiclo(String siglas) {
		return cicloRepository.findFirstBySiglas(siglas);
	}

}
