package com.proyectoIntegrado.service.imple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectoIntegrado.model.Centro;
import com.proyectoIntegrado.repository.CentrosRepository;
import com.proyectoIntegrado.service.CentrosService;

@Service
public class CentrosServiceImple implements CentrosService {

	private CentrosRepository centrosRepositry;

	@Autowired
	public CentrosServiceImple(CentrosRepository centrosRepository) {
		this.centrosRepositry = centrosRepository;
	}

	@Override
	public List<Centro> getCentros() {
		return centrosRepositry.findAll();
	}

}
