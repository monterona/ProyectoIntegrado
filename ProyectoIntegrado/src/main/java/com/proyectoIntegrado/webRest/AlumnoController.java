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
import com.proyectoIntegrado.service.AlumnoService;
import com.proyectoIntegrado.service.Alumno_cicloService;
import com.proyectoIntegrado.service.CicloService;
import com.proyectoIntegrado.service.RedesService;

@RestController
public class AlumnoController extends AbstractResourceController {

	private final AlumnoService alumnoService;
	private final CicloService cicloService;
	private final Alumno_cicloService alumno_cicloService;
	private final RedesService redesService;

	@Autowired
	public AlumnoController(AlumnoService alumnoService, CicloService cicloService,
			Alumno_cicloService alumno_cicloService,RedesService redesService) {
		this.alumnoService = alumnoService;
		this.cicloService = cicloService;
		this.alumno_cicloService = alumno_cicloService;
		this.redesService = redesService;
	}

	@RequestMapping(value = "/alumnos", method = RequestMethod.GET)
	public List<Alumno> alumnos() {
		return alumnoService.getAlumnos();
	}

	@RequestMapping(value = "/alumno/{id}", method = RequestMethod.GET)
	public Alumno alumno(@PathVariable("id") int id) {
		return alumnoService.getAlumno(id);
	}

//	@RequestMapping(value = "/alumno/{siglas}", method = RequestMethod.POST)
//	public void alumno(@RequestBody Alumno alumno, @PathVariable("siglas") String siglas) {
//		Alumno a = alumnoService.save(alumno);
//		Ciclo c = cicloService.getCiclo(siglas);
//		alumno_cicloService.save(alumno.getalumno_ciclo().get(0).getAnnio_fin(),a.getId(), c.getId());
//	}
	
	@RequestMapping(value = "/alumno", method = RequestMethod.POST)
	public void alumno(@RequestBody Alumno alumno) {
		Alumno a = alumnoService.save(alumno);
		int alumno_id = a.getId();
		redesService.save(alumno_id, alumno.getRedes());
		alumno_cicloService.save(alumno_id, alumno.getalumno_ciclo());
	}

	@RequestMapping(value = "ciclo")
	public Ciclo ciclo(@RequestParam("siglas") String siglas) {
		return cicloService.getCiclo(siglas);
	}
	
	@RequestMapping(value = "ciclos")
	public List<Ciclo> getCiclos() {
		return cicloService.getCiclos();
	}
}
