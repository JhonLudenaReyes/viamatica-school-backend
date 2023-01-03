package com.webservice.viamatica.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "maestros")
@Data
public class Maestro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_maestro")
	private Integer idMaestro;
	
	private String nombre;
	
	private String apellido;
	
	private String titulo;
	
	private String estado = "A";

}
