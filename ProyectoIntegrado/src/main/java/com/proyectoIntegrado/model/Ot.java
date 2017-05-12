package com.proyectoIntegrado.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "ot")
public class Ot implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7555899864893264362L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "siglas")
	@NotEmpty
	private String siglas;

	@OneToMany(mappedBy = "ot")
	private List<Alumno_ot> alumno_ot;

	@ManyToOne
	@JoinColumn(name ="centro_id")
	private Centro centro;
	
	public String getSiglas() {
		return siglas;
	}

	public void setSiglas(String siglas) {
		this.siglas = siglas;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Alumno_ot> getAlumno_ot() {
		return alumno_ot;
	}

	public void setAlumno_ot(List<Alumno_ot> alumno_ot) {
		this.alumno_ot = alumno_ot;
	}

	public Centro getCentro() {
		return centro;
	}

	public void setCentro(Centro centro) {
		this.centro = centro;
	}

}
