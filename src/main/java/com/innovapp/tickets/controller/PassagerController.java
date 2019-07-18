package com.innovapp.tickets.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import com.innovapp.tickets.exception.ResourceNotFoundException;
import com.innovapp.tickets.model.Passenger;
import com.innovapp.tickets.repository.PassegerRepository;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class PassagerController {

	@Autowired
	private  PassegerRepository repository;
	
	@GetMapping("/passenger")
	public List<Passenger> findAll(){
		return repository.findAll();
	}
	
	@DeleteMapping("/passenger/{id}")
	public boolean deleteById(@PathVariable Integer id){
		repository.deleteById(id);
		return true;
	}
	
	@GetMapping("/passenger/{id}")
	public Object findById(@PathVariable Integer id){
		return repository.findById(id);
	}
	
	@PostMapping("/passenger")
	public Passenger save(@Valid @RequestBody Passenger passeger){
		return repository.save(passeger);
	}
	
	@PutMapping("/passenger/{id}")
	public Passenger update(@PathVariable Integer id, @Valid @RequestBody Passenger passengerRequest){
		return repository.findById(id).map(passenger -> {
			passenger.setName(passengerRequest.getName());
			passenger.setEmail(passengerRequest.getEmail());
			return repository.save(passenger);
		}).orElseThrow(() -> new ResourceNotFoundException("No se encontro el pasajero con el id " + id ));
	}
	
	
}
