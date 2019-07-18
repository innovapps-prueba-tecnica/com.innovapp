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
import com.innovapp.tickets.model.Ticket;
import com.innovapp.tickets.repository.TicketRepository;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class TicketController {

	@Autowired
	private TicketRepository repository;
	
	@GetMapping("/ticket")
	public List<Ticket> findAll(){
		return repository.findAll();
	}
	
	@DeleteMapping("/ticket/{id}")
	public boolean deleteById(@PathVariable Integer id){
		repository.deleteById(id);
		return true;
	}
	
	@GetMapping("/ticket/{id}")
	public Object findById(@PathVariable Integer id){
		return repository.findById(id);
	}
	
	@PostMapping("/ticket")
	public Ticket save(@Valid @RequestBody Ticket ticket){
		return repository.save(ticket);
	}
	
	@PutMapping("/ticket")
	public Ticket update(@PathVariable Integer id, @Valid @RequestBody Ticket ticketRequest){
		return repository.findById(id).map(ticket -> {
			ticket.setTicketValue(ticketRequest.getTicketValue());
			ticket.setTikectIVA(ticketRequest.getTikectIVA());
			ticket.setDiscountTicket(ticketRequest.getDiscountTicket());
			ticket.setPassenger(ticketRequest.getPassenger());
			ticket.setFlight(ticketRequest.getFlight());
			ticket.setAirplane(ticketRequest.getAirplane());
			return repository.save(ticket);
		}).orElseThrow(() -> new ResourceNotFoundException("No se encontro el avion con el id " + id ));
	}
}
