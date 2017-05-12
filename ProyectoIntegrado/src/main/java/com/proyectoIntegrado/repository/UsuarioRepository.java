package com.proyectoIntegrado.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyectoIntegrado.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,	Integer>{

	Usuario findFirstByUsuarioAndContrasena(String usuario, String contrasena);

}
