package com.proyectoIntegrado.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "ciclo")
public class Ciclo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3879185873573441230L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "nombre")
	@NotEmpty
	private String nombre;

	@Column(name = "siglas")
	@NotEmpty
	private String siglas;

	@OneToMany(mappedBy = "ciclo", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Alumno_ciclo> alumno_ciclos;

	public String getNombre() {
		return nombre;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getSiglas() {
		return siglas;
	}

	public void setSiglas(String siglas) {
		this.siglas = siglas;
	}

	public List<Alumno_ciclo> getAlumno_ciclos() {
		return alumno_ciclos;
	}

	public void setAlumno_ciclos(List<Alumno_ciclo> alumno_ciclos) {
		this.alumno_ciclos = alumno_ciclos;
	}
	public void addAlumno_ciclos(Alumno_ciclo alumno_ciclo) {
		this.alumno_ciclos.add(alumno_ciclo);
		
	}

}
