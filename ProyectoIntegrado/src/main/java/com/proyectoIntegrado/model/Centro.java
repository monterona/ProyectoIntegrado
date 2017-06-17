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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="centro")
public class Centro implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3621397350623970207L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "nombre")
	@NotEmpty
	private String nombre;

	@OneToMany(mappedBy = "centro")
	@JsonIgnore
	private List<Ot> ots;

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

	public List<Ot> getOts() {
		return ots;
	}

	public void setOts(List<Ot> ots) {
		this.ots = ots;
	}

}
