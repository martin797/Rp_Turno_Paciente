package com.giit.demo.Repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.giit.demo.Modelo.Turno;

public interface TurnoRepositorio extends JpaRepository<Turno,Integer>{
	@Query(value = "SELECT r FROM Turno r WHERE r.paciente.id = ?1")
	List<Turno> findByPacienteId(Integer idPaciente);
	@Query(value = "SELECT r FROM Turno r WHERE r.paciente.cedula = ?1")
	List<Turno> findByPacienteCedula(String  idPaciente); 
}
