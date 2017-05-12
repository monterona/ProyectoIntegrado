package com.proyectoIntegrado.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "aptitud")
public class Aptitud implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "nombre")
	@NotEmpty
	private String nombre;

	@OneToMany(mappedBy = "aptitud")
	private List<Alumno_aptitud> alumno_aptitud;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Alumno_aptitud> getAlumno_aptitud() {
		return alumno_aptitud;
	}

	public void setAlumno_aptitud(List<Alumno_aptitud> alumno_aptitud) {
		this.alumno_aptitud = alumno_aptitud;
	}

}