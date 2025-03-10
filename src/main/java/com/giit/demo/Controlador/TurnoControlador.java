package com.giit.demo.Controlador;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.giit.demo.Modelo.Turno;
import com.giit.demo.Repositorio.pacienteRepositorio;
import com.giit.demo.Repositorio.TurnoRepositorio;

@RestController
@RequestMapping("/api/turno")
@CrossOrigin (origins = "*", methods = {RequestMethod.GET,RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
public class TurnoControlador {
	@Autowired
	TurnoRepositorio turnoRepositorio;
	@Autowired
	pacienteRepositorio pacienteRepositorio;
	
	@GetMapping
	public Iterable<Turno> getAll(){
		return turnoRepositorio.findAll();
	}
	
	@GetMapping ("/{id}")
	public Turno getById(@PathVariable(value="id") Integer id) {
		return turnoRepositorio.findById(id).orElseGet(() ->{
    		throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Turno no Encontrado");
    	});
	}

	@PostMapping
	public Turno insertar(@RequestBody Turno turno) { 
		try {
			turno.setPaciente(pacienteRepositorio.save(turno.getPaciente()));
			return turnoRepositorio.save(turno);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Turno no Encontrado");
		}
		
	}
	
	@PutMapping
	public Turno actualizar(@RequestBody Turno turno) {
		return turnoRepositorio.save(turno);
	}
	
	@DeleteMapping ("/{id}")
	public void borrar(@PathVariable(value="id")Integer id) {
		if(turnoRepositorio.findById(id).isPresent()) {
			turnoRepositorio.delete(turnoRepositorio.findById(id).get());
		}
	}
	
	@GetMapping("paciente/{paciente_id}")
    public List<Turno> getTurnoByPaciente(@PathVariable(value = "paciente_id") Integer id) {
        return turnoRepositorio.findByPacienteId(id);
    }
	
	@GetMapping("cedula/{paciente_cedula}")
    public List<Turno> getTurnoByPacienteCedula(@PathVariable(value = "paciente_cedula") String cedula) {
        return turnoRepositorio.findByPacienteCedula(cedula);
    }
	
	@GetMapping("fecha/{paciente_cedula}/{fecha_turno}/{hora}")
    public List<Turno> getTurnoByPacienteFecha(@PathVariable(value = "paciente_cedula") String cedula,@PathVariable(value = "fecha_turno") Date fecha,@PathVariable(value = "hora") String hora) {
        return turnoRepositorio.findByPacienteFecha(cedula,fecha,hora);
    }
}
