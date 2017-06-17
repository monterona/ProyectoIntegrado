package com.proyectoIntegrado.service.imple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectoIntegrado.model.Alumno_ot;
import com.proyectoIntegrado.repository.Alumno_otRepository;
import com.proyectoIntegrado.repository.OtRepository;
import com.proyectoIntegrado.service.Alumno_otService;

@Service
public class Alumno_otServiceImpl implements Alumno_otService {

	private Alumno_otRepository alumno_otRepository;
	private OtRepository otRepository;

	@Autowired
	public Alumno_otServiceImpl(Alumno_otRepository alumno_otRepository, OtRepository otRepository) {
		this.alumno_otRepository = alumno_otRepository;
		this.otRepository = otRepository;
	}

	@Override
	public void save(int alumno_id, List<Alumno_ot> alumno_ots) {
		for (Alumno_ot alumno_ot : alumno_ots) {
			otRepository.save(alumno_ot.getOt());
			alumno_otRepository.save(alumno_ot.getAnnio_fin(), alumno_id, alumno_ot.getOt().getId());
		}
	}

}
