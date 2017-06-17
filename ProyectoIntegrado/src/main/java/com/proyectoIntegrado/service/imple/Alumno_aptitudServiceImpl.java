package com.proyectoIntegrado.service.imple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectoIntegrado.model.Alumno_aptitud;
import com.proyectoIntegrado.repository.Alumno_aptitudRepository;
import com.proyectoIntegrado.service.Alumno_aptitudService;

@Service
public class Alumno_aptitudServiceImpl implements Alumno_aptitudService {

	private Alumno_aptitudRepository alumno_aptitudRepository;

	@Autowired
	public Alumno_aptitudServiceImpl(Alumno_aptitudRepository alumno_aptitudRepository) {
		this.alumno_aptitudRepository = alumno_aptitudRepository;
	}

	@Override
	public void save(int alumno_id, List<Alumno_aptitud> alumnoAptitudes) {
		for (Alumno_aptitud alumnoAptitud : alumnoAptitudes) {
			alumno_aptitudRepository.save(alumnoAptitud.getNivel(), alumno_id, alumnoAptitud.getAptitud().getId());
		}

	}

}
