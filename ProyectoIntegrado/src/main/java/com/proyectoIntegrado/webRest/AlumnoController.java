package com.proyectoIntegrado.webRest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.proyectoIntegrado.model.Alumno;
import com.proyectoIntegrado.model.Ciclo;
import com.proyectoIntegrado.repository.Alumno_cicloRepository;
import com.proyectoIntegrado.service.AlumnoService;
import com.proyectoIntegrado.service.CicloService;

@RestController
public class AlumnoController extends AbstractResourceController {

	private final AlumnoService alumnoService;
	private final CicloService cicloService;
	private final Alumno_cicloRepository alumno_cicloRepository;

	@Autowired
	public AlumnoController(AlumnoService alumnoService, CicloService cicloService,
			Alumno_cicloRepository alumno_cicloRepository) {
		this.alumnoService = alumnoService;
		this.cicloService = cicloService;
		this.alumno_cicloRepository = alumno_cicloRepository;
	}

	@RequestMapping(value = "/alumnos", method = RequestMethod.GET)
	public List<Alumno> alumnos() {
		return alumnoService.getAlumnos();
	}

	@RequestMapping(value = "/alumno/{id}", method = RequestMethod.GET)
	public Alumno alumno(@PathVariable("id") int id) {
		return alumnoService.getAlumno(id);
	}

	@RequestMapping(value = "/alumno/{siglas}", method = RequestMethod.POST)
	public void alumno(@RequestBody Alumno alumno, @PathVariable("siglas") String siglas) {
		Alumno a = alumnoService.save(alumno);
		Ciclo c = cicloService.getCiclo(siglas);
		alumno_cicloRepository.insert("2017-08-05",a.getId(), c.getId());
	}

	@RequestMapping(value = "ciclo")
	public Ciclo ciclo(@RequestParam("siglas") String siglas) {
		return cicloService.getCiclo(siglas);
	}
}
