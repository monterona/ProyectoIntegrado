package com.proyectoIntegrado.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="redes")
public class Redes implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3994355358643711338L;

	public Redes() {
		
	}
	public Redes(Integer id, String link, Alumno alumno) {
		super();
		this.id = id;
		this.link = link;
//		this.alumno = alumno;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
	@Column(name = "link")
    @NotEmpty
    private String link;
	
    @ManyToOne
    @JoinColumn(name = "alumno_id")
	private Alumno alumno;

	public Integer getid() {
		return id;
	}

	public void setid(Integer id) {
		this.id = id;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}
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
	
}
