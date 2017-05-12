package com.proyectoIntegrado.model;

import java.io.Serializable;
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

@Entity
@Table(name="alumno_ot")
public class Alumno_ot implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "alumno_id")
	private Alumno alumno;
	
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "alumno_ot")
	private Ot ot;
	
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

	public Ot getOt() {
		return ot;
	}

	public void setOt(Ot ot) {
		this.ot = ot;
	}

	public Date getAnnio_fin() {
		return annio_fin;
	}

	public void setAnnio_fin(Date annio_fin) {
		this.annio_fin = annio_fin;
	}

	
}
