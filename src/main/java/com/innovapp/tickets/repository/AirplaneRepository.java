package com.innovapp.tickets.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.innovapp.tickets.model.Airplane;

public interface AirplaneRepository extends JpaRepository<Airplane, Integer> {

}
