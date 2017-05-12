package com.proyectoIntegrado.service;

import java.util.List;

import com.proyectoIntegrado.model.Usuario;

public interface UsuariosService {
	Usuario save(Usuario u);
	Usuario login(String usuario,String contrasena);
	List<Usuario> todos();
}
