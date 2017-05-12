package com.proyectoIntegrado.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="alumno_aptitud")
public class Alumno_aptitud implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7547289698515518358L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "nivel")
	private String nivel;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "alumno_id")
	private Alumno alumno;
    
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="aptitud_id")
	private Aptitud aptitud;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public Aptitud getAptitud() {
		return aptitud;
	}

	public void setAptitud(Aptitud aptitud) {
		this.aptitud = aptitud;
	}
	
}
