package com.giit.demo.Controlador;

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
import com.giit.demo.Modelo.Paciente;
import com.giit.demo.Repositorio.PacienteRepositorio;

@RestController
@RequestMapping("/api/paciente")
@CrossOrigin (origins = "*", methods = {RequestMethod.GET,RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
public class PacienteControlador {
	
	@Autowired
	PacienteRepositorio pacienteRepo;
	
	@GetMapping
	public Iterable<Paciente> getAll(){
		return pacienteRepo.findAll();
	}
	
	@GetMapping ("/{id}")
	public Paciente getById(@PathVariable(value="id") Integer id) {
		return pacienteRepo.findById(id).orElseGet(() ->{
    		throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Paciente no Encontrado");
    	});
	}

	@PostMapping
	public Paciente insertar(@RequestBody Paciente paciente) {
		return pacienteRepo.save(paciente);
	}
	
	@PutMapping
	public Paciente actualizar(@RequestBody Paciente paciente) {
		return pacienteRepo.save(paciente);
	}
	
	@DeleteMapping ("/{id}")
	public void borrar(@PathVariable(value="id")Integer id) {
		if(pacienteRepo.findById(id).isPresent()) {
			pacienteRepo.delete(pacienteRepo.findById(id).get());
		}
	}
}