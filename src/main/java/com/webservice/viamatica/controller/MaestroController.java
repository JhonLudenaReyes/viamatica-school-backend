package com.webservice.viamatica.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webservice.viamatica.model.entity.Maestro;
import com.webservice.viamatica.service.MaestroService;

@RestController
@RequestMapping("/maestros")
public class MaestroController {

	@Autowired
	private MaestroService maestroService;

	@GetMapping("/get-maestro/{idMaestro}")
	public ResponseEntity<Maestro> getMaestro(@PathVariable("idMaestro") int idMaestro) {
		return maestroService.getMaestro(idMaestro).map(maestro -> new ResponseEntity<>(maestro, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@GetMapping("/get-maestros")
	public ResponseEntity<List<Maestro>> getMaestros() {
		return maestroService.getMaestros().map(maestro -> new ResponseEntity<>(maestro, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@PostMapping("/save")
	public ResponseEntity<Maestro> save(@RequestBody Maestro maestro) {
		return new ResponseEntity<>(maestroService.save(maestro), HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Maestro> update(@RequestBody Maestro maestro){
		Optional<Maestro> maestroOptional = maestroService.getMaestro(maestro.getIdMaestro());
		if(maestroOptional.isPresent()) {
			return new ResponseEntity<>(maestroService.save(maestro), HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@PutMapping("/delete/{idMaestro}")
	public ResponseEntity<Maestro> delete(@PathVariable("idMaestro") int idMaestro){
		Optional<Maestro> maestroOptional = maestroService.getMaestro(idMaestro);
		if(maestroOptional.isPresent()) {
			Maestro updateMaestro = maestroOptional.get();
			updateMaestro.setEstado("I");
			return new ResponseEntity<>(maestroService.save(updateMaestro), HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
