package com.proyectoIntegrado.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.proyectoIntegrado.model.Alumno_ciclo;

@Repository
public interface Alumno_cicloRepository extends JpaRepository<Alumno_ciclo, Integer>{
	
	@Transactional
	@Modifying
	@Query(value = "insert into alumno_ciclo (annio_fin,alumno_id,ciclo_id) VALUES (:annio_fin, :alumno_id, :ciclo_id)", nativeQuery = true)
	void insert(@Param("annio_fin")String annio_fin, @Param("alumno_id") int alumno_id, @Param("ciclo_id") int ciclo_id);
}
