package com.proyectoIntegrado.webRest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.proyectoIntegrado.model.Alumno;
import com.proyectoIntegrado.model.Alumno_ciclo;
import com.proyectoIntegrado.model.Usuario;
import com.proyectoIntegrado.repository.AlumnoRepository;
import com.proyectoIntegrado.repository.Alumno_cicloRepository;
import com.proyectoIntegrado.service.UsuariosService;

@RestController
public class LoginController extends AbstractResourceController {
	private static final Logger log = LoggerFactory.getLogger(LoginController.class);
	private final UsuariosService usuarioService;
	private final AlumnoRepository alumnoRepository;
	private final Alumno_cicloRepository alumno_cicloRepository;

	@Autowired
	public LoginController(UsuariosService usuariosService,AlumnoRepository alumnoRepository, Alumno_cicloRepository alumno_cicloRepository) {
		this.usuarioService=usuariosService;
		this.alumnoRepository=alumnoRepository;
		this.alumno_cicloRepository=alumno_cicloRepository;
	}

//	@InitBinder
//	public void setAllowedFields(WebDataBinder dataBinder) {
//		dataBinder.setDisallowedFields("id");
//	}
//	
	@RequestMapping(value = "/login")
	public Usuario login(@RequestParam("usuario")String usuario,@RequestParam("contrasena")String contrasena){
		Usuario u = usuarioService.login(usuario, contrasena);
		//log.info(u.toString());
		return u;
	}
	@RequestMapping(value = "/alumno")
	public Alumno alumno(){
		Alumno a=alumnoRepository.findOne(1);
		return a;
	}
	@RequestMapping(value = "/alumnos")
	public Alumno_ciclo alumnos(){
		Alumno_ciclo a=alumno_cicloRepository.findOne(1);
		return a;
	}
//	@RequestMapping(value = "/alumno")
//	public ResponseEntity<Alumno> alumno(){
//		Alumno a=alumnoRepository.findOne(1);
//		return ResponseEntity.ok(a);
//	}
	@RequestMapping(value = "/usuario")
	public Usuario usuario(@RequestBody Usuario user){
		Usuario u=new Usuario();
		u.setId(user.getId());
		u.setUsuario(user.getUsuario());
		u.setContrasena(user.getContrasena());
		u.setRol_profesor(user.getRol_profesor());
		usuarioService.save(u);
		return u;
	}
}
