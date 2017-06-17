package com.proyectoIntegrado.model;

import java.io.Serializable;
import java.util.Date;

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
@Table(name="alumno_ot")
public class Alumno_ot implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2739022514317767653L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
    @ManyToOne
    @JoinColumn(name = "alumno_id")
    @JsonIgnore
	private Alumno alumno;
	
    @ManyToOne
    @JoinColumn(name = "ot_id")
	private Ot ot;
	
	@Column(name = "annio_fin")
	@Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy/MM/dd")
	//@JsonFormat(pattern = "dd-MM-yyyy")
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
