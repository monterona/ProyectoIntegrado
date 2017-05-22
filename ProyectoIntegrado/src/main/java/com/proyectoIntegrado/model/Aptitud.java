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
@Table(name = "aptitud")
public class Aptitud implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9204597049943057573L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "nombre")
	@NotEmpty
	private String nombre;

	@OneToMany(mappedBy = "aptitud", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Alumno_aptitud> alumno_aptitudes;

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

	public List<Alumno_aptitud> getAlumno_aptitudes() {
		return alumno_aptitudes;
	}

	public void setAlumno_aptitudes(List<Alumno_aptitud> alumno_aptitudes) {
		this.alumno_aptitudes = alumno_aptitudes;

	}

	public void addAlumno_aptitudes(Alumno_aptitud alumno_aptitud) {
		this.alumno_aptitudes.add(alumno_aptitud);
		if (alumno_aptitud.getAptitud() != this) {
			alumno_aptitud.setAptitud(this);
		}
	}

}