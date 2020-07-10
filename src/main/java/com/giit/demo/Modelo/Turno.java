package com.giit.demo.Modelo;

import java.sql.Date;

import javax.persistence.*;

@Entity
@Table (name="turno")
public class Turno {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="turno_id")
	private int id;
	
	@Column(name="IdMedico")
	private int id_medico;
	
	@Column(name="IdEspecialidad")
	private int id_especialidad;
	
	@Column(name="CostoConslta")
	private float costo_consulta;
	
	@Column(name="FechaTurno")
	private Date fecha;
	
	@Column(name="Hora")
	private String hora;
	
	@Column(name="Confirmacion")
	private boolean confirmacion;

	@ManyToOne
	@JoinColumn(name = "IdPaciente")
	Paciente pacient; 
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_medico() {
		return id_medico;
	}

	public void setId_medico(int id_medico) {
		this.id_medico = id_medico;
	}

	public int getId_especialidad() {
		return id_especialidad;
	}

	public void setId_especialidad(int id_especialidad) {
		this.id_especialidad = id_especialidad;
	}

	public float getCosto_consulta() {
		return costo_consulta;
	}

	public void setCosto_consulta(float costo_consulta) {
		this.costo_consulta = costo_consulta;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public boolean isConfirmacion() {
		return confirmacion;
	}

	public void setConfirmacion(boolean confirmacion) {
		this.confirmacion = confirmacion;
	}
	
	
	
	
}
