package com.proyectoIntegrado.service.imple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.proyectoIntegrado.model.Usuario;
import com.proyectoIntegrado.repository.UsuarioRepository;
import com.proyectoIntegrado.service.UsuariosService;
@Service
public class UsuarioServiceImpl implements UsuariosService {

	private UsuarioRepository usuarioRepository;
	
	@Autowired
	public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}
	
	@Override
	public Usuario login(String usuario, String contrasena) throws DataAccessException{
		return usuarioRepository.findFirstByUsuarioAndContrasena(usuario,contrasena); 
	}

	@Override
	public Usuario save(Usuario u) {
		return usuarioRepository.save(u);
	}

	@Override
	public List<Usuario> todos() {
		return usuarioRepository.findAll();
	}

}
