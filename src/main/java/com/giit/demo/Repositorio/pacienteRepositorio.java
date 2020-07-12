package com.giit.demo.Repositorio;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.giit.demo.Modelo.Paciente;

public interface pacienteRepositorio extends JpaRepository<Paciente,Integer> {
	@Query(value = "SELECT r FROM Paciente r WHERE r.cedula = ?1")
	List<Paciente> findByPacienteCedula(String paciente_cedula); 
}
