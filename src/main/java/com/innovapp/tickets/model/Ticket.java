package com.innovapp.tickets.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="tickets")
public class Ticket {

	@Id
    @GeneratedValue(generator = "tickets_generator")
    @SequenceGenerator(
            name = "tickets_generator",
            sequenceName = "tickets_sequence",
            initialValue = 1000
    )
	private Integer Id;
	
	@NotBlank
	private Double ticketValue;
	
	
	private Double tikectIVA;
	
	@NotBlank
	private Double discountTicket;
	
	@NotBlank
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "passenger_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
	private Passenger passenger;
	
	@NotBlank
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "flight_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
	private Flight flight;
	
	@NotBlank
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "airplane_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
	private Airplane airplane;

	public Ticket() {}

	public Double getTicketValue() {
		return ticketValue;
	}

	public void setTicketValue(Double ticketValue) {
		this.ticketValue = ticketValue;
	}

	public Double getTikectIVA() {
		return tikectIVA;
	}

	public void setTikectIVA(Double tikectIVA) {
		this.tikectIVA = tikectIVA;
	}

	public Double getDiscountTicket() {
		return discountTicket;
	}

	public void setDiscountTicket(Double discountTicket) {
		this.discountTicket = discountTicket;
	}
	

	public Passenger getPassenger() {
		return passenger;
	}

	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public Airplane getAirplane() {
		return airplane;
	}

	public void setAirplane(Airplane airplane) {
		this.airplane = airplane;
	}

	public Integer getId() {
		return Id;
	}
		
}
