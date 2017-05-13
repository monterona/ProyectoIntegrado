package com.proyectoIntegrado.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "alumno")
public class Alumno implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7288777393404527349L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "nombre")

	private String nombre;

	@Column(name = "apellido1")

	private String apellido1;

	@Column(name = "apellido2")

	private String apellido2;

	@Column(name = "fecha_nac")

	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date fecha_nac;

	@Column(name = "direccion")

	private String direccion;

	@Column(name = "localidad")

	private String localidad;

	@Column(name = "cp")

	private int cp;

	@Column(name = "provincia")

	private String provincia;

	@Column(name = "telefono")

	private int telefono;

	@Column(name = "email")

	private String email;

	@Column(name = "email2")
	private String email2;

	@Column(name = "disponibilidad")
	private int disponibilidad;

	@Column(name = "observaciones")
	private String observaciones;

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

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public Date getFecha_nac() {
		return fecha_nac;
	}

	public void setFecha_nac(Date fecha_nac) {
		this.fecha_nac = fecha_nac;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public int getCp() {
		return cp;
	}

	public void setCp(int cp) {
		this.cp = cp;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail2() {
		return email2;
	}

	public void setEmail2(String email2) {
		this.email2 = email2;
	}

	public int isDisponibilidad() {
		return disponibilidad;
	}

	public void setDisponibilidad(int disponibilidad) {
		this.disponibilidad = disponibilidad;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	@OneToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

	@OneToMany(mappedBy = "alumno")
	private List<Redes> redes;

	@OneToMany(mappedBy = "alumno")
	private List<Alumno_ciclo> alumno_ciclos;

	@OneToMany(mappedBy = "alumno")
	private List<Alumno_ot> alumno_ot;

	@OneToMany(mappedBy = "alumno")
	private List<Alumno_aptitud> alumno_aptitudes;

	public Usuario getUsuario() {
		return usuario;
	}

	public List<Redes> getRedes() {
		return redes;
	}

	public void setRedes(List<Redes> redes) {
		this.redes = redes;
	}

	public int getDisponibilidad() {
		return disponibilidad;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Alumno_ciclo> getAlumno_ciclos() {
		return alumno_ciclos;
	}

	public void setAlumno_ciclos(List<Alumno_ciclo> alumno_ciclos) {
		this.alumno_ciclos = alumno_ciclos;
	}

	public List<Alumno_ot> getAlumno_ot() {
		return alumno_ot;
	}

	public void setAlumno_ot(List<Alumno_ot> alumno_ot) {
		this.alumno_ot = alumno_ot;
	}

	public List<Alumno_aptitud> getAlumno_aptitudes() {
		return alumno_aptitudes;
	}

	public void setAlumno_aptitudes(List<Alumno_aptitud> alumno_aptitudes) {
		this.alumno_aptitudes = alumno_aptitudes;
	}

}
