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

import com.giit.demo.Modelo.Turno;
import com.giit.demo.Repositorio.TurnoRepositorio;

@RestController
@RequestMapping("/api/turno")
@CrossOrigin (origins = "*", methods = {RequestMethod.GET,RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
public class TurnoControlador {
	@Autowired
	TurnoRepositorio clienteRepo;
	
	@GetMapping
	public Iterable<Turno> getAll(){
		return clienteRepo.findAll();
	}
	
	@GetMapping ("/{id}")
	public Turno getById(@PathVariable(value="id") Integer id) {
		return clienteRepo.findById(id).orElseGet(() ->{
    		throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Turno no Encontrado");
    	});
	}

	@PostMapping
	public Turno insertar(@RequestBody Turno turno) {
		return clienteRepo.save(turno);
	}
	
	@PutMapping
	public Turno actualizar(@RequestBody Turno turno) {
		return clienteRepo.save(turno);
	}
	
	@DeleteMapping ("/{id}")
	public void borrar(@PathVariable(value="id")Integer id) {
		if(clienteRepo.findById(id).isPresent()) {
			clienteRepo.delete(clienteRepo.findById(id).get());
		}
	}
}
