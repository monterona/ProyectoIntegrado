package com.proyectoIntegrado.service.imple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectoIntegrado.model.Redes;
import com.proyectoIntegrado.repository.RedesRepository;
import com.proyectoIntegrado.service.RedesService;

@Service
public class RedesServiceImpl implements RedesService {

private RedesRepository redesRepository;
	
	@Autowired
	public RedesServiceImpl(RedesRepository redesRepository) {
		this.redesRepository=redesRepository;
	}
	
	@Override
	public void save(int alumno_id,List <Redes> redes) {
		for(Redes red : redes){
			redesRepository.save(red.getLink(), alumno_id);
		}
		 
	}

}
