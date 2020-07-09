package com.giit.demo.Modelo;

import javax.persistence.*;

import java.sql.Date;

@Entity
@Table (name="paciente")
public class Paciente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="paciente_id")
	private int id;
	
	@Column(name="paciente_cedula")
	private String cedula;
	
	@Column(name="paciente_nombre")
	private String nombre;
	
	@Column(name="paciente_direccion")
	private String direccion;
	
	@Column(name="paciente_telefono")
	private String telefono;
	
	@Column(name="paciente_fecha_nacimiento")
	private Date fecha_nacimiento;
	
	@Column(name="paciente_nacionalidad")
	private String nacionalidad;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}
	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}
	public String getNacionalidad() {
		return nacionalidad;
	}
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	
	
}
