package com.proyectoIntegrado.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.proyectoIntegrado.model.Alumno_aptitud;

@Repository
public interface Alumno_aptitudRepository extends JpaRepository<Alumno_aptitud, Integer> {

	@Transactional
	@Modifying
	@Query(value = "insert into alumno_aptitud (nivel,alumno_id,aptitud_id) VALUES (:nivel, :alumno_id, :aptitud_id)", nativeQuery = true)
	void save(@Param("nivel") String nivel, @Param("alumno_id") int alumno_id, @Param("aptitud_id") int aptitud_id);
}
