package com.proyectoIntegrado.webRest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.proyectoIntegrado.model.Usuario;
import com.proyectoIntegrado.service.UsuariosService;

@RestController
public class LoginController extends AbstractResourceController {
	private final UsuariosService usuarioService;

	@Autowired
	public LoginController(UsuariosService usuariosService) {
		this.usuarioService=usuariosService;
	}
	
	@RequestMapping(value = "/login",method=RequestMethod.POST)
	public Usuario login(@RequestBody Usuario user){
		return usuarioService.login(user.getUsuario(), user.getContrasena());
	}
	
	@RequestMapping(value = "/addUsuario",method=RequestMethod.POST)
	public Usuario usuario(@RequestBody Usuario user){
		return usuarioService.save(user);
	}
}
