package com.proyectoIntegrado.service.imple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectoIntegrado.model.Alumno_ciclo;
import com.proyectoIntegrado.repository.Alumno_cicloRepository;
import com.proyectoIntegrado.service.Alumno_cicloService;

@Service
public class Alumno_cicloServiceImpl implements Alumno_cicloService {

	private Alumno_cicloRepository alumno_cicloRepository;
	
	@Autowired
	public Alumno_cicloServiceImpl(Alumno_cicloRepository alumno_cicloRepository) {
		this.alumno_cicloRepository = alumno_cicloRepository;
	}

	@Override
	public void save(int alumno_id, List<Alumno_ciclo> alumno_ciclos) {
		for (Alumno_ciclo alumno_ciclo : alumno_ciclos){
			alumno_cicloRepository.save(alumno_ciclo.getAnnio_fin(), alumno_id, alumno_ciclo.getCiclo().getId());
		}
		
	}
	
	

}
