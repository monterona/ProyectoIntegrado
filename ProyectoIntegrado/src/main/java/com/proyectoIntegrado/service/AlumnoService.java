package com.proyectoIntegrado.service;

import java.util.List;

import com.proyectoIntegrado.model.Alumno;

public interface AlumnoService {
	Alumno save(Alumno a);
	Alumno getAlumno(Integer i);
	List<Alumno> getAlumnos();
}
