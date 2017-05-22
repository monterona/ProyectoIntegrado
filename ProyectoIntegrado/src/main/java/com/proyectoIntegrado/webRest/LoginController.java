package com.proyectoIntegrado.webRest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.proyectoIntegrado.model.Usuario;
import com.proyectoIntegrado.service.UsuariosService;

@RestController
public class LoginController extends AbstractResourceController {
	private static final Logger log = LoggerFactory.getLogger(LoginController.class);
	private final UsuariosService usuarioService;
	//private final Alumno_cicloRepository alumno_cicloRepository;

	@Autowired
	public LoginController(UsuariosService usuariosService) {
		this.usuarioService=usuariosService;
		//this.alumno_cicloRepository=alumno_cicloRepository;
	}

//	@InitBinder
//	public void setAllowedFields(WebDataBinder dataBinder) {
//		dataBinder.setDisallowedFields("id");
//	}
	
	@RequestMapping(value = "/login",method=RequestMethod.POST)
	public Usuario login(@RequestParam("usuario")String usuario,@RequestParam("contrasena")String contrasena){
		Usuario u = usuarioService.login(usuario, contrasena);
		//log.info(u.toString());
		return u;
	}
	
	@RequestMapping(value = "/usuario",method=RequestMethod.POST)
	public Usuario usuario(@RequestBody Usuario user){
		return usuarioService.save(user);
	}
}
