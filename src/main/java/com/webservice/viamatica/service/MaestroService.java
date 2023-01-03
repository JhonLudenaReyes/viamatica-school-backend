package com.webservice.viamatica.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webservice.viamatica.model.dao.MaestroDaoRepository;
import com.webservice.viamatica.model.entity.Maestro;

@Service
public class MaestroService {
	
	@Autowired
	private MaestroDaoRepository maestroDaoRepository;
	
	public Optional<Maestro> getMaestro(int idMaestro){
		Optional<Maestro> maestro = maestroDaoRepository.findByIdMaestroAndEstado(idMaestro, "A"); 
		return maestro;
	}
	
	public Optional<List<Maestro>> getMaestros(){
		Optional<List<Maestro>> maestros = maestroDaoRepository.findAllByEstado("A");
		return maestros;
	}
	
	public Maestro save(Maestro maestro) {
		return maestroDaoRepository.save(maestro);
	}

}
