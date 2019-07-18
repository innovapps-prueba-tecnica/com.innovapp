package com.innovapp.tickets.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.innovapp.tickets.model.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {

}
