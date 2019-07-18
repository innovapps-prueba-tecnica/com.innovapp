package com.innovapp.tickets.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.innovapp.tickets.model.Flight;

public interface FlightRepository extends JpaRepository<Flight, Integer> {

}
