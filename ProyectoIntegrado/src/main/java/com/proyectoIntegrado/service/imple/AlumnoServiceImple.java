package com.proyectoIntegrado.service.imple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectoIntegrado.model.Alumno;
import com.proyectoIntegrado.repository.AlumnoRepository;
import com.proyectoIntegrado.service.AlumnoService;

@Service
public class AlumnoServiceImple implements AlumnoService {
	
	private AlumnoRepository alumnoRepository;
	
	@Autowired
	public AlumnoServiceImple(AlumnoRepository alumnoRepository) {
		this.alumnoRepository=alumnoRepository;
	}
	
	@Override
	public Alumno save(Alumno a) {
		return alumnoRepository.save(a);
	}

	@Override
	public Alumno getAlumno(int i) {
		return alumnoRepository.findOne(i);
	}

	@Override
	public List<Alumno> getAlumnos() {
		return alumnoRepository.findAll();
	}

}
