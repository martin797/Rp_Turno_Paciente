package com.giit.demo.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.giit.demo.Modelo.Paciente;

public interface PacienteRepositorio extends JpaRepository<Paciente,Integer> {
	

}
