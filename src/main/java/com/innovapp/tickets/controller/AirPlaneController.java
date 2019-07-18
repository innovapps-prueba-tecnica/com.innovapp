package com.innovapp.tickets.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.innovapp.tickets.exception.ResourceNotFoundException;
import com.innovapp.tickets.model.Airplane;
import com.innovapp.tickets.repository.AirplaneRepository;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class AirPlaneController {
	@Autowired
	private  AirplaneRepository repository;
	
	@GetMapping("/airplane")
	public List<Airplane> findAll(){
		return repository.findAll();
	}
	
	@DeleteMapping("/airplane/{id}")
	public boolean deleteById(@PathVariable Integer id){
		repository.deleteById(id);
		return true;
	}
	
	@GetMapping("/airplane/{id}")
	public Object findById(@PathVariable Integer id){
		return repository.findById(id);
	}
	
	@PostMapping("/airplane")
	public Airplane save(@Valid @RequestBody Airplane passeger){
		System.out.println(passeger);
		return repository.save(passeger);
	}
	
	@PutMapping("/airplane/{id}")
	public Airplane update(@PathVariable Integer id, @Valid @RequestBody Airplane airPlaneRequest){
		return repository.findById(id).map(airPlane -> {
			airPlane.setAirline(airPlaneRequest.getAirline());
			airPlane.setDescription(airPlaneRequest.getDescription());
			airPlane.setMaximunQuantity(airPlaneRequest.getMaximunQuantity());
			return repository.save(airPlane);
		}).orElseThrow(() -> new ResourceNotFoundException("No se encontro el pasajero con el id " + id ));
	}
}
