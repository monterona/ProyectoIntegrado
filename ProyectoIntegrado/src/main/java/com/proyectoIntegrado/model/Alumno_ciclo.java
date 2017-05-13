package com.proyectoIntegrado.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="alumno_ciclo")
public class Alumno_ciclo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "alumno_id")
    @JsonIgnore
	private Alumno alumno;
	
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ciclo_id")
	private Ciclo ciclo;
	
	@Column(name = "annio_fin")
	@Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date annio_fin;

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

	public Ciclo getCiclo() {
		return ciclo;
	}

	public void setCiclo(Ciclo ciclo) {
		this.ciclo = ciclo;
	}

	public Date getAnnio_fin() {
		return annio_fin;
	}

	public void setAnnio_fin(Date annio_fin) {
		this.annio_fin = annio_fin;
	}
	
	
}
