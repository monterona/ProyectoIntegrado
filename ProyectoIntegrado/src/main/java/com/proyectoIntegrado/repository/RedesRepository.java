package com.proyectoIntegrado.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.proyectoIntegrado.model.Redes;

public interface RedesRepository extends JpaRepository<Redes, Integer>{

	@Transactional
	@Modifying
	@Query(value = "insert into redes (link,alumno_id) VALUES (:link, :alumno_id)", nativeQuery = true)
	void save(@Param("link")String link, @Param("alumno_id") int alumno_id);
}
