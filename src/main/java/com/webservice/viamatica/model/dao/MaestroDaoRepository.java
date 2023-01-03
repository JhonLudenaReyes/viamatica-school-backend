package com.webservice.viamatica.model.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webservice.viamatica.model.entity.Maestro;

public interface MaestroDaoRepository extends JpaRepository<Maestro, Integer>{
	
	Optional<Maestro> findByIdMaestroAndEstado(int idMaestro, String estado);
	
	Optional<List<Maestro>> findAllByEstado(String estado);

}
