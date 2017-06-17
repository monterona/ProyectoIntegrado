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
import com.proyectoIntegrado.model.Aptitud;
import com.proyectoIntegrado.model.Centro;
import com.proyectoIntegrado.model.Ciclo;
import com.proyectoIntegrado.service.AlumnoService;
import com.proyectoIntegrado.service.Alumno_aptitudService;
import com.proyectoIntegrado.service.Alumno_cicloService;
import com.proyectoIntegrado.service.Alumno_otService;
import com.proyectoIntegrado.service.AptitudService;
import com.proyectoIntegrado.service.CentrosService;
import com.proyectoIntegrado.service.CicloService;
import com.proyectoIntegrado.service.RedesService;

@RestController
public class AlumnoController extends AbstractResourceController {

	private final AlumnoService alumnoService;
	private final CicloService cicloService;
	private final Alumno_cicloService alumno_cicloService;
	private final RedesService redesService;
	private final AptitudService aptitudService;
	private final Alumno_aptitudService alumno_aptitudService;
	private final Alumno_otService alumno_otService;
	private final CentrosService centrosService;

	@Autowired
	public AlumnoController(AlumnoService alumnoService, CicloService cicloService,
			Alumno_cicloService alumno_cicloService, RedesService redesService, AptitudService aptitudService,
			Alumno_aptitudService alumno_aptitudService, Alumno_otService alumno_otService,
			CentrosService centrosService) {
		this.alumnoService = alumnoService;
		this.cicloService = cicloService;
		this.alumno_cicloService = alumno_cicloService;
		this.redesService = redesService;
		this.aptitudService = aptitudService;
		this.alumno_aptitudService = alumno_aptitudService;
		this.alumno_otService = alumno_otService;
		this.centrosService = centrosService;
	}

	@RequestMapping(value = "/alumnos", method = RequestMethod.GET)
	public List<Alumno> alumnos() {
		return alumnoService.getAlumnos();
	}

	@RequestMapping(value = "/alumno/{id}", method = RequestMethod.GET)
	public Alumno alumno(@PathVariable("id") int id) {
		return alumnoService.getAlumno(id);
	}

	@RequestMapping(value = "/alumno", method = RequestMethod.POST)
	public void alumno(@RequestBody Alumno alumno) {
		Alumno a = alumnoService.save(alumno);
		int alumno_id = a.getId();
		redesService.save(a.getId(), alumno.getRedes());
		alumno_cicloService.save(alumno_id, alumno.getalumno_ciclo());
		alumno_aptitudService.save(alumno_id, alumno.getAlumno_aptitudes());
		alumno_otService.save(alumno_id, alumno.getAlumno_ot());
	}

	@RequestMapping(value = "ciclos", method = RequestMethod.GET)
	public List<Ciclo> getCiclos() {
		return cicloService.getCiclos();
	}

	@RequestMapping(value = "aptitudes", method = RequestMethod.GET)
	public List<Aptitud> getAptitudes() {
		return aptitudService.getAptitudes();
	}

	@RequestMapping(value = "aptitud", method = RequestMethod.POST)
	public Aptitud saveAptitudes(@RequestParam("aptitud") String nombre) {
		Aptitud aptitud = new Aptitud();
		aptitud.setNombre(nombre);
		return aptitudService.save(aptitud);
	}

	@RequestMapping(value = "centros", method = RequestMethod.GET)
	public List<Centro> getCentros() {
		return centrosService.getCentros();
	}
}
